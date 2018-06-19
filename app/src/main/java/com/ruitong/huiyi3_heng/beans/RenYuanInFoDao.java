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
 * DAO for table "REN_YUAN_IN_FO".
*/
public class RenYuanInFoDao extends AbstractDao<RenYuanInFo, Long> {

    public static final String TABLENAME = "REN_YUAN_IN_FO";

    /**
     * Properties of entity RenYuanInFo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AccountId = new Property(0, int.class, "accountId", false, "ACCOUNT_ID");
        public final static Property AssemblyId = new Property(1, String.class, "assemblyId", false, "ASSEMBLY_ID");
        public final static Property Channel = new Property(2, int.class, "channel", false, "CHANNEL");
        public final static Property Come_from = new Property(3, String.class, "come_from", false, "COME_FROM");
        public final static Property CompanyName = new Property(4, String.class, "companyName", false, "COMPANY_NAME");
        public final static Property Country = new Property(5, String.class, "country", false, "COUNTRY");
        public final static Property CreateTime = new Property(6, long.class, "createTime", false, "CREATE_TIME");
        public final static Property Department = new Property(7, String.class, "department", false, "DEPARTMENT");
        public final static Property DtoResult = new Property(8, int.class, "dtoResult", false, "DTO_RESULT");
        public final static Property Gender = new Property(9, int.class, "gender", false, "GENDER");
        public final static Property Id = new Property(10, Long.class, "id", true, "_id");
        public final static Property Identity = new Property(11, String.class, "identity", false, "IDENTITY");
        public final static Property JobStatus = new Property(12, int.class, "jobStatus", false, "JOB_STATUS");
        public final static Property Location = new Property(13, String.class, "location", false, "LOCATION");
        public final static Property MeetingId = new Property(14, int.class, "meetingId", false, "MEETING_ID");
        public final static Property ModifyTime = new Property(15, long.class, "modifyTime", false, "MODIFY_TIME");
        public final static Property Name = new Property(16, String.class, "name", false, "NAME");
        public final static Property NamePinyin = new Property(17, String.class, "namePinyin", false, "NAME_PINYIN");
        public final static Property Num = new Property(18, int.class, "num", false, "NUM");
        public final static Property PageNum = new Property(19, int.class, "pageNum", false, "PAGE_NUM");
        public final static Property PageSize = new Property(20, int.class, "pageSize", false, "PAGE_SIZE");
        public final static Property Phone = new Property(21, String.class, "phone", false, "PHONE");
        public final static Property Photo_ids = new Property(22, String.class, "photo_ids", false, "PHOTO_IDS");
        public final static Property Province = new Property(23, String.class, "province", false, "PROVINCE");
        public final static Property Remark = new Property(24, String.class, "remark", false, "REMARK");
        public final static Property Sid = new Property(25, int.class, "sid", false, "SID");
        public final static Property SourceMeeting = new Property(26, String.class, "sourceMeeting", false, "SOURCE_MEETING");
        public final static Property SourceQuestionJson = new Property(27, String.class, "sourceQuestionJson", false, "SOURCE_QUESTION_JSON");
        public final static Property Status = new Property(28, int.class, "status", false, "STATUS");
        public final static Property Subject_type = new Property(29, int.class, "subject_type", false, "SUBJECT_TYPE");
        public final static Property Title = new Property(30, String.class, "title", false, "TITLE");
    }


    public RenYuanInFoDao(DaoConfig config) {
        super(config);
    }
    
    public RenYuanInFoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"REN_YUAN_IN_FO\" (" + //
                "\"ACCOUNT_ID\" INTEGER NOT NULL ," + // 0: accountId
                "\"ASSEMBLY_ID\" TEXT," + // 1: assemblyId
                "\"CHANNEL\" INTEGER NOT NULL ," + // 2: channel
                "\"COME_FROM\" TEXT," + // 3: come_from
                "\"COMPANY_NAME\" TEXT," + // 4: companyName
                "\"COUNTRY\" TEXT," + // 5: country
                "\"CREATE_TIME\" INTEGER NOT NULL ," + // 6: createTime
                "\"DEPARTMENT\" TEXT," + // 7: department
                "\"DTO_RESULT\" INTEGER NOT NULL ," + // 8: dtoResult
                "\"GENDER\" INTEGER NOT NULL ," + // 9: gender
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 10: id
                "\"IDENTITY\" TEXT," + // 11: identity
                "\"JOB_STATUS\" INTEGER NOT NULL ," + // 12: jobStatus
                "\"LOCATION\" TEXT," + // 13: location
                "\"MEETING_ID\" INTEGER NOT NULL ," + // 14: meetingId
                "\"MODIFY_TIME\" INTEGER NOT NULL ," + // 15: modifyTime
                "\"NAME\" TEXT," + // 16: name
                "\"NAME_PINYIN\" TEXT," + // 17: namePinyin
                "\"NUM\" INTEGER NOT NULL ," + // 18: num
                "\"PAGE_NUM\" INTEGER NOT NULL ," + // 19: pageNum
                "\"PAGE_SIZE\" INTEGER NOT NULL ," + // 20: pageSize
                "\"PHONE\" TEXT," + // 21: phone
                "\"PHOTO_IDS\" TEXT," + // 22: photo_ids
                "\"PROVINCE\" TEXT," + // 23: province
                "\"REMARK\" TEXT," + // 24: remark
                "\"SID\" INTEGER NOT NULL ," + // 25: sid
                "\"SOURCE_MEETING\" TEXT," + // 26: sourceMeeting
                "\"SOURCE_QUESTION_JSON\" TEXT," + // 27: sourceQuestionJson
                "\"STATUS\" INTEGER NOT NULL ," + // 28: status
                "\"SUBJECT_TYPE\" INTEGER NOT NULL ," + // 29: subject_type
                "\"TITLE\" TEXT);"); // 30: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REN_YUAN_IN_FO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RenYuanInFo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAccountId());
 
        String assemblyId = entity.getAssemblyId();
        if (assemblyId != null) {
            stmt.bindString(2, assemblyId);
        }
        stmt.bindLong(3, entity.getChannel());
 
        String come_from = entity.getCome_from();
        if (come_from != null) {
            stmt.bindString(4, come_from);
        }
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(5, companyName);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(6, country);
        }
        stmt.bindLong(7, entity.getCreateTime());
 
        String department = entity.getDepartment();
        if (department != null) {
            stmt.bindString(8, department);
        }
        stmt.bindLong(9, entity.getDtoResult());
        stmt.bindLong(10, entity.getGender());
        stmt.bindLong(11, entity.getId());
 
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(12, identity);
        }
        stmt.bindLong(13, entity.getJobStatus());
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(14, location);
        }
        stmt.bindLong(15, entity.getMeetingId());
        stmt.bindLong(16, entity.getModifyTime());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(17, name);
        }
 
        String namePinyin = entity.getNamePinyin();
        if (namePinyin != null) {
            stmt.bindString(18, namePinyin);
        }
        stmt.bindLong(19, entity.getNum());
        stmt.bindLong(20, entity.getPageNum());
        stmt.bindLong(21, entity.getPageSize());
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(22, phone);
        }
 
        String photo_ids = entity.getPhoto_ids();
        if (photo_ids != null) {
            stmt.bindString(23, photo_ids);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(24, province);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(25, remark);
        }
        stmt.bindLong(26, entity.getSid());
 
        String sourceMeeting = entity.getSourceMeeting();
        if (sourceMeeting != null) {
            stmt.bindString(27, sourceMeeting);
        }
 
        String sourceQuestionJson = entity.getSourceQuestionJson();
        if (sourceQuestionJson != null) {
            stmt.bindString(28, sourceQuestionJson);
        }
        stmt.bindLong(29, entity.getStatus());
        stmt.bindLong(30, entity.getSubject_type());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(31, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RenYuanInFo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAccountId());
 
        String assemblyId = entity.getAssemblyId();
        if (assemblyId != null) {
            stmt.bindString(2, assemblyId);
        }
        stmt.bindLong(3, entity.getChannel());
 
        String come_from = entity.getCome_from();
        if (come_from != null) {
            stmt.bindString(4, come_from);
        }
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(5, companyName);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(6, country);
        }
        stmt.bindLong(7, entity.getCreateTime());
 
        String department = entity.getDepartment();
        if (department != null) {
            stmt.bindString(8, department);
        }
        stmt.bindLong(9, entity.getDtoResult());
        stmt.bindLong(10, entity.getGender());
        stmt.bindLong(11, entity.getId());
 
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(12, identity);
        }
        stmt.bindLong(13, entity.getJobStatus());
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(14, location);
        }
        stmt.bindLong(15, entity.getMeetingId());
        stmt.bindLong(16, entity.getModifyTime());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(17, name);
        }
 
        String namePinyin = entity.getNamePinyin();
        if (namePinyin != null) {
            stmt.bindString(18, namePinyin);
        }
        stmt.bindLong(19, entity.getNum());
        stmt.bindLong(20, entity.getPageNum());
        stmt.bindLong(21, entity.getPageSize());
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(22, phone);
        }
 
        String photo_ids = entity.getPhoto_ids();
        if (photo_ids != null) {
            stmt.bindString(23, photo_ids);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(24, province);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(25, remark);
        }
        stmt.bindLong(26, entity.getSid());
 
        String sourceMeeting = entity.getSourceMeeting();
        if (sourceMeeting != null) {
            stmt.bindString(27, sourceMeeting);
        }
 
        String sourceQuestionJson = entity.getSourceQuestionJson();
        if (sourceQuestionJson != null) {
            stmt.bindString(28, sourceQuestionJson);
        }
        stmt.bindLong(29, entity.getStatus());
        stmt.bindLong(30, entity.getSubject_type());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(31, title);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 10);
    }    

    @Override
    public RenYuanInFo readEntity(Cursor cursor, int offset) {
        RenYuanInFo entity = new RenYuanInFo( //
            cursor.getInt(offset + 0), // accountId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // assemblyId
            cursor.getInt(offset + 2), // channel
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // come_from
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // companyName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // country
            cursor.getLong(offset + 6), // createTime
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // department
            cursor.getInt(offset + 8), // dtoResult
            cursor.getInt(offset + 9), // gender
            cursor.getLong(offset + 10), // id
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // identity
            cursor.getInt(offset + 12), // jobStatus
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // location
            cursor.getInt(offset + 14), // meetingId
            cursor.getLong(offset + 15), // modifyTime
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // name
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // namePinyin
            cursor.getInt(offset + 18), // num
            cursor.getInt(offset + 19), // pageNum
            cursor.getInt(offset + 20), // pageSize
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // phone
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // photo_ids
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // province
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // remark
            cursor.getInt(offset + 25), // sid
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // sourceMeeting
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // sourceQuestionJson
            cursor.getInt(offset + 28), // status
            cursor.getInt(offset + 29), // subject_type
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RenYuanInFo entity, int offset) {
        entity.setAccountId(cursor.getInt(offset + 0));
        entity.setAssemblyId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChannel(cursor.getInt(offset + 2));
        entity.setCome_from(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCompanyName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCountry(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCreateTime(cursor.getLong(offset + 6));
        entity.setDepartment(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDtoResult(cursor.getInt(offset + 8));
        entity.setGender(cursor.getInt(offset + 9));
        entity.setId(cursor.getLong(offset + 10));
        entity.setIdentity(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setJobStatus(cursor.getInt(offset + 12));
        entity.setLocation(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setMeetingId(cursor.getInt(offset + 14));
        entity.setModifyTime(cursor.getLong(offset + 15));
        entity.setName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setNamePinyin(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setNum(cursor.getInt(offset + 18));
        entity.setPageNum(cursor.getInt(offset + 19));
        entity.setPageSize(cursor.getInt(offset + 20));
        entity.setPhone(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setPhoto_ids(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setProvince(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setRemark(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setSid(cursor.getInt(offset + 25));
        entity.setSourceMeeting(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setSourceQuestionJson(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setStatus(cursor.getInt(offset + 28));
        entity.setSubject_type(cursor.getInt(offset + 29));
        entity.setTitle(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RenYuanInFo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RenYuanInFo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RenYuanInFo entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}