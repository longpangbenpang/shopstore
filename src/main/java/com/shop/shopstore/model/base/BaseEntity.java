package com.shop.shopstore.model.base;

import com.shop.shopstore.common.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Long on 2019/4/4.
 * 共有类
 */
public class BaseEntity {

    private String id; //主键、
    private Date createdTime;

    private Date updatedTime;

    private String createdBy;

    private String updatedBy;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    protected boolean isNewRecord = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        setId(UUID.randomUUID().toString().replaceAll("-", ""));
        this.createdBy = SessionUtils.getSession().getName();
        this.createdTime = new Date();
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        this.updatedBy = SessionUtils.getSession().getName();
        this.updatedTime = new Date();

    }
}
