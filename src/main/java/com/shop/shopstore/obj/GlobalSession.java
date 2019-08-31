package com.shop.shopstore.obj;

import java.io.Serializable;
import java.util.List;

/**
 * 全局对象
 */
public class GlobalSession implements Serializable {
    private static final long serialVersionUID = 5408656601124446745L;
    public static final String SESSION_KEY="SHOP_SESSION";
    public static final String TOKEN_KEY="SHOP_TIKEN";
    private String id;
    private List<String> permissions;
    private String account;
    //用户名称
    private String name;
    //用户所属机构id
    private String orgId;
    //用户所属机构名称
    private String orgName;
    //机构英文名称
    private String orgEnName;
    private String idcard;
    private String sex;
    private String eMail;
    private String mobile;
    private String qq;
    private String comm_address;
    private String lastlogin_time;
    private String end_time;
    private String type;
    private String status;
    private String extend;
    private String remark;

    private String language;

    public GlobalSession() {
        this.language = "en";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if("ch".equals(language)||"en".equals(language)||"fr".equals(language)){
            this.language = language;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgEnName() {
        return orgEnName;
    }

    public void setOrgEnName(String orgEnName) {
        this.orgEnName = orgEnName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getComm_address() {
        return comm_address;
    }

    public void setComm_address(String comm_address) {
        this.comm_address = comm_address;
    }

    public String getLastlogin_time() {
        return lastlogin_time;
    }

    public void setLastlogin_time(String lastlogin_time) {
        this.lastlogin_time = lastlogin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
