package com.ruitong.huiyi3.dialogall;

import android.app.Dialog;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ruitong.huiyi3.R;
import com.ruitong.huiyi3.beans.Tishi;


/**
 * Created by 于德海 on 2016/9/8.
 *
 * @version ${VERSION}
 * @decpter
 */
public class CommonDialogService extends Service implements CommonDialogListener {

    private static Dialog dialog;
    private static TextView a1,tishi;
//    private static ImageView img_loading;
    private static View view;
//    private static AnimationDrawable animationDrawable;
    private ProgressBar progressBar;
    private Button button;


    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==111){
                Tishi tishi1= (Tishi) msg.obj;

                a1.setText(tishi1.getA());
                tishi.setText(tishi1.getTishi());
                progressBar.setProgress(tishi1.getP());
            }

            return false;
        }
    });

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.getInstances().setListener(this);//绑定

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(dialog!=null&&dialog.isShowing()){
            dialog.cancel();
            dialog=null;
        }
    }

    private void showDialog(String a,String t,int p){
       // Log.d("CommonDialogService", "显示");
        if(dialog==null&&CommonData.mNowContext!=null){
          //  Log.d("CommonDialogService", "显示2");
            dialog = new Dialog(CommonData.mNowContext,R.style.dialog_style);
            view = LayoutInflater.from(this).inflate(R.layout.alldialog,null,false);
            a1 = (TextView) view.findViewById(R.id.a1);
            tishi = (TextView) view.findViewById(R.id.tishi);
            button = (Button) view.findViewById(R.id.guanbi);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    dialog=null;
                }
            });

            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);


            dialog.setContentView(view);
            dialog.setCanceledOnTouchOutside(false);

            dialog.show();

            Window window= dialog.getWindow();
            if ( window != null) {
                WindowManager.LayoutParams attr = window.getAttributes();
                if (attr != null) {
                    attr.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    attr.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    attr.gravity = Gravity.CENTER;//设置dialog 在布局中的位置
                    dialog.getWindow().setAttributes(attr);
                }
            }

//            WindowManager.LayoutParams lp = dialog.getWindow()
//                    .getAttributes();
//            if(CommonData.ScreenWidth!=0)
//            lp.width =  CommonData.ScreenWidth/ 3;
//
//            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        }else {
            Tishi tishi=new Tishi();
            tishi.setA(a);
            tishi.setP(p);
            tishi.setTishi(t);
            Message message=Message.obtain();
            message.what=111;
            message.obj=tishi;
           handler.sendMessage(message);


        }
    }

    @Override
    public void show(String a, String t, int p) {
       showDialog(a,t,p);
    }

    @Override
    public void cancel() {
         if(dialog!=null){
                dialog.dismiss();
                dialog=null;

         }
    }
}
