package com.ruitong.huiyi3.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.ruitong.huiyi3.view.AutoScrollTextView.TAG;

/**
 * Created by chenjun on 2017/5/17.
 */

public class FileUtil {
    public static final String SDPATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String PATH = "ruitongPD";

    /**
     * 是否支持SDCard
     */
    public static boolean isSupportSDCard() {
        return Environment.getExternalStorageDirectory().exists();
    }
    /**
     * 获取所有存储卡挂载路径
     * @return
     */
    public static List<String> getMountPathList() {
        List<String> pathList = new ArrayList<String>();
        final String cmd = "cat /proc/mounts";
        Runtime run = Runtime.getRuntime();//取得当前JVM的运行时环境
        try {
            Process p = run.exec(cmd);//执行命令
            BufferedInputStream inputStream = new BufferedInputStream(p.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 获得命令执行后在控制台的输出信息
                // Log.d("",line);
                //输出信息内容：  /data/media /storage/emulated/0 sdcardfs rw,nosuid,nodev,relatime,uid=1023,gid=1023 0 0
                String[] temp = TextUtils.split(line, " ");
                //分析内容可看出第二个空格后面是路径
                String result = temp[1];
                File file = new File(result);
                //类型为目录、可读、可写，就算是一条挂载路径
                if (file.isDirectory() && file.canRead() && file.canWrite()) {
                    // Logger.d("add --> "+file.getAbsolutePath());
                    pathList.add(result);
                }

                // 检查命令是否执行失败
                if (p.waitFor() != 0 && p.exitValue() == 1) {
                    // p.exitValue()==0表示正常结束，1：非正常结束
                    Log.d("","命令执行失败!");
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            Log.d("",e.toString()+"f");
            //命令执行异常，就添加默认的路径
            pathList.add(Environment.getExternalStorageDirectory().getAbsolutePath());
        }
        return pathList;
    }

    //  往SD卡写入文件的方法
    public static void savaFileToSD(String filename, String filecontent) throws Exception {
        //如果手机已插入sd卡,且app具有读写sd卡的权限
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            filename = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + filename;

            //这里就不要用openFileOutput了,那个是往手机内存中写数据的
            FileOutputStream output = new FileOutputStream(filename,true);
            output.write(filecontent.getBytes());
            //将String字符串以字节流的形式写入到输出流中
            output.close();
            //关闭输出流
        }
    }


    public static void Unzip(String zipFile, String targetDir) {
        int BUFFER = 1024*100; //这里缓冲区我们使用4KB，
        String strEntry; //保存每个zip的条目名称

        try {
            BufferedOutputStream dest = null; //缓冲输出流
            FileInputStream fis = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry entry; //每个zip条目的实例

            while ((entry = zis.getNextEntry()) != null) {

                try {
                  //  Log.i("Unzip: ","="+ entry);
                    int count;
                    byte data[] = new byte[BUFFER];
                    strEntry = entry.getName();
                   // Log.d("FileUtil", strEntry);
                    File entryFile = new File(targetDir +File.separator+ strEntry);
                 //   Log.d("FileUtil", "entryFile.isFile():" + entryFile.isFile());

//                    File entryDir = new File(entryFile.getParent());
//                    if (!entryDir.exists()) {
//                        entryDir.mkdirs();
//                    }

                    FileOutputStream fos = new FileOutputStream(entryFile);
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = zis.read(data, 0, BUFFER)) != -1) {
                        dest.write(data, 0, count);
                    }
                    dest.flush();
                    dest.close();
                 //   Log.d("FileUtil", "5555");
                } catch (Exception ex) {
                    Log.d("FileUtil", ex.getMessage()+"解压文件异常");
                }
            }
            zis.close();
        } catch (Exception cwj) {
            Log.d("FileUtil", cwj.getMessage()+"解压文件异常");
        }
    }

    public interface ZipListener {
        /** 开始解压 */
        void zipStart();

        /** 解压成功 */
        void zipSuccess();

        /** 解压进度 */
        void zipProgress(int progress);

        /** 解压失败 */
        void zipFail();
    }

    /**
     * 获取压缩包解压后的内存大小
     *
     * @param filePath
     *            文件路径
     * @return 返回内存long类型的值
     */
    public static long getZipTrueSize(String filePath) {
        long size = 0;
        ZipFile f;
        try {
            f = new ZipFile(filePath);
            Enumeration<? extends ZipEntry> en = f.entries();
            while (en.hasMoreElements()) {
                size += en.nextElement().getSize();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }




    /**
     * [* 使用 org.apache.tools.zip.ZipFile 解压文件，它与 java 类库中的
     * java.util.zip.ZipFile 使用方式是一新的，只不过多了设置编码方式的 接口。
     * 注，apache 没有提供 ZipInputStream 类，所以只能使用它提供的ZipFile 来读取压缩文件。]<BR>
     * @param archive 压缩包路径
     * @param decompressDir 解压路径
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ZipException
     */
    public static void readByApacheZipFile(String archive, String decompressDir,ZipListener listener)
            throws IOException, FileNotFoundException, ZipException {

        long sumLength = 0;
        long ziplength = getZipTrueSize(archive);
        Log.e(TAG, "readByApacheZipFile"+ziplength);
       // BufferedInputStream bi;
        ZipFile zf = new ZipFile(archive);// 支持中文
        Enumeration e = zf.entries();
        InputStream is = null;
        int count=0;

        while(e.hasMoreElements()) {

            ZipEntry entry= (ZipEntry) e.nextElement();

            is= zf.getInputStream(entry);

            File dstFile = new File(decompressDir+"/"+entry.getName());
            if (dstFile.exists()){
                is.close();
                continue;
            }
            FileOutputStream  fos= new FileOutputStream(dstFile);

            byte[]buffer = new byte[10240];

            while((count = is.read(buffer, 0, buffer.length)) != -1){
                sumLength += count;
                int progress = (int) ((sumLength * 100) / ziplength);
                updateProgress(progress, listener);
                fos.write(buffer,0,count);
            }
            fos.close();
            is.close();
        }

//        while (e.hasMoreElements()) {
//            ZipEntry ze2 = (ZipEntry) e.nextElement();
//            String entryName = ze2.getName();
//            Log.e(TAG, entryName);
//            String path = decompressDir + "/" + entryName;
//            if (ze2.isDirectory()) {
//                Log.e(TAG, "正在创建解压目录 - " + entryName);
//                File decompressDirFile = new File(path);
//                if (!decompressDirFile.exists()) {
//                    decompressDirFile.mkdirs();
//                }
//            } else {
//
//
//                Log.e(TAG, "正在创建解压文件 - " + entryName);
//                String fileDir = path.substring(0, path.lastIndexOf("/"));
//                File fileDirFile = new File(fileDir);
//                if (!fileDirFile.exists()) {
//                    fileDirFile.mkdirs();
//                }
//                BufferedOutputStream bos = new BufferedOutputStream(
//                        new FileOutputStream(decompressDir + "/" + entryName));
//                bi = new BufferedInputStream(zf.getInputStream(ze2));
//                byte[] readContent = new byte[10240];
//                int readCount = bi.read(readContent);
//                while (readCount != -1) {
//                    sumLength += readCount;
//                    int progress = (int) ((sumLength * 100) / ziplength);
//                    updateProgress(progress, listener);
//
//                    bos.write(readContent, 0, readCount);
//                    readCount = bi.read(readContent);
//                }
//                bos.close();
//            }
//        }
        zf.close();
    }

   private static int lastProgress = 0;
    private static void updateProgress(int progress, ZipListener listener2) {
        /** 因为会频繁的刷新,这里我只是进度>1%的时候才去显示 */
        if (progress > lastProgress) {
            lastProgress = progress;
            listener2.zipProgress(progress);
        }
    }

    /**
     * 获取指定目录内所有文件路径
     * @param dirPath 需要查询的文件目录
     * @param
     */
    public static List<String> getAllFileXml(String dirPath, List<String> fileList) {
        File f = new File(dirPath);
        Log.d("FileUtilXML", "f.exists():" + f.exists()+dirPath);
        if (!f.exists()) {//判断路径是否存在
            return null;
        }

        File[] files = f.listFiles();
        // Log.d("FileUtil", "files.length:" + files.length);
        if(files==null){//判断权限
            return null;
        }

        Log.d("FileUtilXml", "文件夹个数" + files.length);

        for (File _file : files) {//遍历目录
            if(_file.isFile() && (_file.getName().endsWith("xml") )){
                String _name=_file.getName();
                String filePath = _file.getAbsolutePath();//获取文件路径
                //  String fileName = _file.getName().substring(0,_name.length()-4);//获取文件名
                //  Log.d("LOGCAT","fileName:"+fileName);
                // Log.d("LOGCAT","filePath:"+filePath);
                try {
                    fileList.add(filePath);

                }catch (Exception e){
                    Log.d("FileUtil", e.getMessage()+"获取usb文件异常");
                }
            } else if(_file.isDirectory()){//查询子目录
                getAllFileXml(_file.getAbsolutePath(),fileList);
            }
        }
        Log.d("FileUtil", "返回的xml个数:" + fileList.size());
        return fileList;
    }



    /**
     * 获取指定目录内所有文件路径
     * @param dirPath 需要查询的文件目录
     * @param
     */
    public static List<String> getAllFiles(String dirPath, List<String> fileList) {
        File f = new File(dirPath);
        Log.d("FileUtil", "f.exists():" + f.exists()+dirPath);
        if (!f.exists()) {//判断路径是否存在
            return null;
        }

        File[] files = f.listFiles();
       // Log.d("FileUtil", "files.length:" + files.length);
        if(files==null){//判断权限
            return null;
        }

        Log.d("FileUtil", "文件夹个数" + files.length);

        for (File _file : files) {//遍历目录
            if(_file.isFile() && (_file.getName().endsWith("zip") )){
                String _name=_file.getName();
                String filePath = _file.getAbsolutePath();//获取文件路径
                //  String fileName = _file.getName().substring(0,_name.length()-4);//获取文件名
                //  Log.d("LOGCAT","fileName:"+fileName);
                // Log.d("LOGCAT","filePath:"+filePath);
                try {
                    fileList.add(filePath);

                }catch (Exception e){
                    Log.d("FileUtil", e.getMessage()+"获取usb文件异常");
                }
            } else if(_file.isDirectory()){//查询子目录
                getAllFiles(_file.getAbsolutePath(),fileList);
            }
        }
        Log.d("FileUtil", "返回的jsonArray:" + fileList.size());
        return fileList;
    }

    /**
     * 检测文件或者路径是否存在
     * <p>
     * 可以给值为Null，如果给值null,判断路径是否存在
     */

    public static boolean isExists(String path, String fileName) {
        if (null == path && null == fileName) {
            return false;
        }
        String name;
        name = SDPATH + File.separator + path;
        File file = new File(name);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileNmae = new File(name, fileName);
        return fileNmae.exists();
    }

    public static boolean isExists(String path) {
        if (null == path) {
            return false;
        }
        String name;

        name = SDPATH + File.separator + path;

        File file = new File(name);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.exists();
    }

    /**
     * 检查SD卡是否可用
     */
    public static boolean isAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState());
    }


    /***
     *保存bitmap对象到文件中
     * @param bm
     * @param path
     * @param quality
     * @return
     */
    public static boolean saveBitmap2File(Bitmap bm, String path, int quality) {
        if (null == bm || bm.isRecycled()) {
            return false;
        }
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(file));
            bm.compress(Bitmap.CompressFormat.JPEG, quality, bos);
            bos.flush();
            bos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (null != bm) {
                if (!bm.isRecycled()) {
                    bm.recycle();
                }
                bm = null;
            }
        }
    }
}
