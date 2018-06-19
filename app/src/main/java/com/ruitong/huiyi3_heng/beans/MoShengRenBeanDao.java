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
 * DAO for table "MO_SHENG_REN_BEAN".
*/
public class MoShengRenBeanDao extends AbstractDao<MoShengRenBean, Long> {

    public static final String TABLENAME = "MO_SHENG_REN_BEAN";

    /**
     * Properties of entity MoShengRenBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
    }


    public MoShengRenBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MoShengRenBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MO_SHENG_REN_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"URL\" TEXT);"); // 1: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MO_SHENG_REN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MoShengRenBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MoShengRenBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public MoShengRenBean readEntity(Cursor cursor, int offset) {
        MoShengRenBean entity = new MoShengRenBean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MoShengRenBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MoShengRenBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MoShengRenBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MoShengRenBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
