package com.ruitong.huiyi3_heng.beans;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ZHU_JI_BEAN_H".
*/
public class ZhuJiBeanHDao extends AbstractDao<ZhuJiBeanH, Long> {

    public static final String TABLENAME = "ZHU_JI_BEAN_H";

    /**
     * Properties of entity ZhuJiBeanH.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AccountId = new Property(0, int.class, "accountId", false, "ACCOUNT_ID");
        public final static Property CreateTime = new Property(1, long.class, "createTime", false, "CREATE_TIME");
        public final static Property DtoResult = new Property(2, int.class, "dtoResult", false, "DTO_RESULT");
        public final static Property HostUrl = new Property(3, String.class, "hostUrl", false, "HOST_URL");
        public final static Property Id = new Property(4, Long.class, "id", true, "_id");
        public final static Property MachineCode = new Property(5, String.class, "machineCode", false, "MACHINE_CODE");
        public final static Property MachineName = new Property(6, String.class, "machineName", false, "MACHINE_NAME");
        public final static Property ModifyTime = new Property(7, long.class, "modifyTime", false, "MODIFY_TIME");
        public final static Property PageNum = new Property(8, int.class, "pageNum", false, "PAGE_NUM");
        public final static Property PageSize = new Property(9, int.class, "pageSize", false, "PAGE_SIZE");
        public final static Property Pwd = new Property(10, String.class, "pwd", false, "PWD");
        public final static Property Status = new Property(11, int.class, "status", false, "STATUS");
        public final static Property Username = new Property(12, String.class, "username", false, "USERNAME");
    }


    public ZhuJiBeanHDao(DaoConfig config) {
        super(config);
    }
    
    public ZhuJiBeanHDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ZHU_JI_BEAN_H\" (" + //
                "\"ACCOUNT_ID\" INTEGER NOT NULL ," + // 0: accountId
                "\"CREATE_TIME\" INTEGER NOT NULL ," + // 1: createTime
                "\"DTO_RESULT\" INTEGER NOT NULL ," + // 2: dtoResult
                "\"HOST_URL\" TEXT," + // 3: hostUrl
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 4: id
                "\"MACHINE_CODE\" TEXT," + // 5: machineCode
                "\"MACHINE_NAME\" TEXT," + // 6: machineName
                "\"MODIFY_TIME\" INTEGER NOT NULL ," + // 7: modifyTime
                "\"PAGE_NUM\" INTEGER NOT NULL ," + // 8: pageNum
                "\"PAGE_SIZE\" INTEGER NOT NULL ," + // 9: pageSize
                "\"PWD\" TEXT," + // 10: pwd
                "\"STATUS\" INTEGER NOT NULL ," + // 11: status
                "\"USERNAME\" TEXT);"); // 12: username
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ZHU_JI_BEAN_H\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ZhuJiBeanH entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAccountId());
        stmt.bindLong(2, entity.getCreateTime());
        stmt.bindLong(3, entity.getDtoResult());
 
        String hostUrl = entity.getHostUrl();
        if (hostUrl != null) {
            stmt.bindString(4, hostUrl);
        }
        stmt.bindLong(5, entity.getId());
 
        String machineCode = entity.getMachineCode();
        if (machineCode != null) {
            stmt.bindString(6, machineCode);
        }
 
        String machineName = entity.getMachineName();
        if (machineName != null) {
            stmt.bindString(7, machineName);
        }
        stmt.bindLong(8, entity.getModifyTime());
        stmt.bindLong(9, entity.getPageNum());
        stmt.bindLong(10, entity.getPageSize());
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(11, pwd);
        }
        stmt.bindLong(12, entity.getStatus());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(13, username);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ZhuJiBeanH entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAccountId());
        stmt.bindLong(2, entity.getCreateTime());
        stmt.bindLong(3, entity.getDtoResult());
 
        String hostUrl = entity.getHostUrl();
        if (hostUrl != null) {
            stmt.bindString(4, hostUrl);
        }
        stmt.bindLong(5, entity.getId());
 
        String machineCode = entity.getMachineCode();
        if (machineCode != null) {
            stmt.bindString(6, machineCode);
        }
 
        String machineName = entity.getMachineName();
        if (machineName != null) {
            stmt.bindString(7, machineName);
        }
        stmt.bindLong(8, entity.getModifyTime());
        stmt.bindLong(9, entity.getPageNum());
        stmt.bindLong(10, entity.getPageSize());
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(11, pwd);
        }
        stmt.bindLong(12, entity.getStatus());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(13, username);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 4);
    }    

    @Override
    public ZhuJiBeanH readEntity(Cursor cursor, int offset) {
        ZhuJiBeanH entity = new ZhuJiBeanH( //
            cursor.getInt(offset + 0), // accountId
            cursor.getLong(offset + 1), // createTime
            cursor.getInt(offset + 2), // dtoResult
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // hostUrl
            cursor.getLong(offset + 4), // id
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // machineCode
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // machineName
            cursor.getLong(offset + 7), // modifyTime
            cursor.getInt(offset + 8), // pageNum
            cursor.getInt(offset + 9), // pageSize
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // pwd
            cursor.getInt(offset + 11), // status
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12) // username
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ZhuJiBeanH entity, int offset) {
        entity.setAccountId(cursor.getInt(offset + 0));
        entity.setCreateTime(cursor.getLong(offset + 1));
        entity.setDtoResult(cursor.getInt(offset + 2));
        entity.setHostUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setId(cursor.getLong(offset + 4));
        entity.setMachineCode(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMachineName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setModifyTime(cursor.getLong(offset + 7));
        entity.setPageNum(cursor.getInt(offset + 8));
        entity.setPageSize(cursor.getInt(offset + 9));
        entity.setPwd(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setStatus(cursor.getInt(offset + 11));
        entity.setUsername(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ZhuJiBeanH entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ZhuJiBeanH entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ZhuJiBeanH entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
