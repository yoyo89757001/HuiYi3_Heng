package com.ruitong.huiyi3_heng.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/5/30.
 */
@Entity
public class BenDiMBbean {


    /**
     * screenId : 10100097
     * sid : 0
     * createTime : 1527647796122
     * bottemImageUrl : "http://192.168.2.154:8080/gapp/images/welcome/business/template.jpg"
     * welcomeSpeak : 发送到发大水
     * subType : 观众
     * pageSize : 0
     * popupImageUrl : "http://192.168.2.154:8080/gapp/images/welcome/business/template1_popup2.jpg"
     * dtoResult : 0
     * companyId : 0
     * modifyTime : 1527647796122
     * pageNum : 0
     */
    @Id
    @NotNull
    private Long id;
    private String screenId;
    private int sid;
    private long createTime;
    private String bottemImageUrl;
    private String welcomeSpeak;
    private String subType;
    private int pageSize;
    private String popupImageUrl;
    private int dtoResult;
    private int companyId;
    private long modifyTime;
    private int pageNum;
    private int photo_index;
    @Generated(hash = 284274718)
    public BenDiMBbean(@NotNull Long id, String screenId, int sid, long createTime,
            String bottemImageUrl, String welcomeSpeak, String subType, int pageSize,
            String popupImageUrl, int dtoResult, int companyId, long modifyTime, int pageNum,
            int photo_index) {
        this.id = id;
        this.screenId = screenId;
        this.sid = sid;
        this.createTime = createTime;
        this.bottemImageUrl = bottemImageUrl;
        this.welcomeSpeak = welcomeSpeak;
        this.subType = subType;
        this.pageSize = pageSize;
        this.popupImageUrl = popupImageUrl;
        this.dtoResult = dtoResult;
        this.companyId = companyId;
        this.modifyTime = modifyTime;
        this.pageNum = pageNum;
        this.photo_index = photo_index;
    }
    @Generated(hash = 628008177)
    public BenDiMBbean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getScreenId() {
        return this.screenId;
    }
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
    public int getSid() {
        return this.sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    public String getBottemImageUrl() {
        return this.bottemImageUrl;
    }
    public void setBottemImageUrl(String bottemImageUrl) {
        this.bottemImageUrl = bottemImageUrl;
    }
    public String getWelcomeSpeak() {
        return this.welcomeSpeak;
    }
    public void setWelcomeSpeak(String welcomeSpeak) {
        this.welcomeSpeak = welcomeSpeak;
    }
    public String getSubType() {
        return this.subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public int getPageSize() {
        return this.pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String getPopupImageUrl() {
        return this.popupImageUrl;
    }
    public void setPopupImageUrl(String popupImageUrl) {
        this.popupImageUrl = popupImageUrl;
    }
    public int getDtoResult() {
        return this.dtoResult;
    }
    public void setDtoResult(int dtoResult) {
        this.dtoResult = dtoResult;
    }
    public int getCompanyId() {
        return this.companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public long getModifyTime() {
        return this.modifyTime;
    }
    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
    public int getPageNum() {
        return this.pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPhoto_index() {
        return this.photo_index;
    }
    public void setPhoto_index(int photo_index) {
        this.photo_index = photo_index;
    }


}
