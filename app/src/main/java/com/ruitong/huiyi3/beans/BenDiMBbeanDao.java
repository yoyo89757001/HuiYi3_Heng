package com.ruitong.huiyi3.beans;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BEN_DI_MBBEAN".
*/
public class BenDiMBbeanDao extends AbstractDao<BenDiMBbean, Long> {

    public static final String TABLENAME = "BEN_DI_MBBEAN";

    /**
     * Properties of entity BenDiMBbean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ScreenId = new Property(1, String.class, "screenId", false, "SCREEN_ID");
        public final static Property Sid = new Property(2, int.class, "sid", false, "SID");
        public final static Property CreateTime = new Property(3, long.class, "createTime", false, "CREATE_TIME");
        public final static Property BottemImageUrl = new Property(4, String.class, "bottemImageUrl", false, "BOTTEM_IMAGE_URL");
        public final static Property WelcomeSpeak = new Property(5, String.class, "welcomeSpeak", false, "WELCOME_SPEAK");
        public final static Property SubType = new Property(6, String.class, "subType", false, "SUB_TYPE");
        public final static Property PageSize = new Property(7, int.class, "pageSize", false, "PAGE_SIZE");
        public final static Property PopupImageUrl = new Property(8, String.class, "popupImageUrl", false, "POPUP_IMAGE_URL");
        public final static Property DtoResult = new Property(9, int.class, "dtoResult", false, "DTO_RESULT");
        public final static Property CompanyId = new Property(10, int.class, "companyId", false, "COMPANY_ID");
        public final static Property ModifyTime = new Property(11, long.class, "modifyTime", false, "MODIFY_TIME");
        public final static Property PageNum = new Property(12, int.class, "pageNum", false, "PAGE_NUM");
        public final static Property Photo_index = new Property(13, int.class, "photo_index", false, "PHOTO_INDEX");
    }


    public BenDiMBbeanDao(DaoConfig config) {
        super(config);
    }
    
    public BenDiMBbeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BEN_DI_MBBEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"SCREEN_ID\" TEXT," + // 1: screenId
                "\"SID\" INTEGER NOT NULL ," + // 2: sid
                "\"CREATE_TIME\" INTEGER NOT NULL ," + // 3: createTime
                "\"BOTTEM_IMAGE_URL\" TEXT," + // 4: bottemImageUrl
                "\"WELCOME_SPEAK\" TEXT," + // 5: welcomeSpeak
                "\"SUB_TYPE\" TEXT," + // 6: subType
                "\"PAGE_SIZE\" INTEGER NOT NULL ," + // 7: pageSize
                "\"POPUP_IMAGE_URL\" TEXT," + // 8: popupImageUrl
                "\"DTO_RESULT\" INTEGER NOT NULL ," + // 9: dtoResult
                "\"COMPANY_ID\" INTEGER NOT NULL ," + // 10: companyId
                "\"MODIFY_TIME\" INTEGER NOT NULL ," + // 11: modifyTime
                "\"PAGE_NUM\" INTEGER NOT NULL ," + // 12: pageNum
                "\"PHOTO_INDEX\" INTEGER NOT NULL );"); // 13: photo_index
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BEN_DI_MBBEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BenDiMBbean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String screenId = entity.getScreenId();
        if (screenId != null) {
            stmt.bindString(2, screenId);
        }
        stmt.bindLong(3, entity.getSid());
        stmt.bindLong(4, entity.getCreateTime());
 
        String bottemImageUrl = entity.getBottemImageUrl();
        if (bottemImageUrl != null) {
            stmt.bindString(5, bottemImageUrl);
        }
 
        String welcomeSpeak = entity.getWelcomeSpeak();
        if (welcomeSpeak != null) {
            stmt.bindString(6, welcomeSpeak);
        }
 
        String subType = entity.getSubType();
        if (subType != null) {
            stmt.bindString(7, subType);
        }
        stmt.bindLong(8, entity.getPageSize());
 
        String popupImageUrl = entity.getPopupImageUrl();
        if (popupImageUrl != null) {
            stmt.bindString(9, popupImageUrl);
        }
        stmt.bindLong(10, entity.getDtoResult());
        stmt.bindLong(11, entity.getCompanyId());
        stmt.bindLong(12, entity.getModifyTime());
        stmt.bindLong(13, entity.getPageNum());
        stmt.bindLong(14, entity.getPhoto_index());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BenDiMBbean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String screenId = entity.getScreenId();
        if (screenId != null) {
            stmt.bindString(2, screenId);
        }
        stmt.bindLong(3, entity.getSid());
        stmt.bindLong(4, entity.getCreateTime());
 
        String bottemImageUrl = entity.getBottemImageUrl();
        if (bottemImageUrl != null) {
            stmt.bindString(5, bottemImageUrl);
        }
 
        String welcomeSpeak = entity.getWelcomeSpeak();
        if (welcomeSpeak != null) {
            stmt.bindString(6, welcomeSpeak);
        }
 
        String subType = entity.getSubType();
        if (subType != null) {
            stmt.bindString(7, subType);
        }
        stmt.bindLong(8, entity.getPageSize());
 
        String popupImageUrl = entity.getPopupImageUrl();
        if (popupImageUrl != null) {
            stmt.bindString(9, popupImageUrl);
        }
        stmt.bindLong(10, entity.getDtoResult());
        stmt.bindLong(11, entity.getCompanyId());
        stmt.bindLong(12, entity.getModifyTime());
        stmt.bindLong(13, entity.getPageNum());
        stmt.bindLong(14, entity.getPhoto_index());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public BenDiMBbean readEntity(Cursor cursor, int offset) {
        BenDiMBbean entity = new BenDiMBbean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // screenId
            cursor.getInt(offset + 2), // sid
            cursor.getLong(offset + 3), // createTime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // bottemImageUrl
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // welcomeSpeak
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // subType
            cursor.getInt(offset + 7), // pageSize
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // popupImageUrl
            cursor.getInt(offset + 9), // dtoResult
            cursor.getInt(offset + 10), // companyId
            cursor.getLong(offset + 11), // modifyTime
            cursor.getInt(offset + 12), // pageNum
            cursor.getInt(offset + 13) // photo_index
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BenDiMBbean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setScreenId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSid(cursor.getInt(offset + 2));
        entity.setCreateTime(cursor.getLong(offset + 3));
        entity.setBottemImageUrl(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWelcomeSpeak(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSubType(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPageSize(cursor.getInt(offset + 7));
        entity.setPopupImageUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDtoResult(cursor.getInt(offset + 9));
        entity.setCompanyId(cursor.getInt(offset + 10));
        entity.setModifyTime(cursor.getLong(offset + 11));
        entity.setPageNum(cursor.getInt(offset + 12));
        entity.setPhoto_index(cursor.getInt(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BenDiMBbean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BenDiMBbean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BenDiMBbean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
