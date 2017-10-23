package com.cn.inuyasha.model.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * Principal
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = -7498429614384423750L;
    private Integer id;
    private String type;
    private String fullname;
    private String mobile;
    private String head;
    private Object openId;
    private String nickName;
    private Set<String> permissions;

    public Principal() {
    }

    public Principal(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Object getOpenId() {
        return openId;
    }

    public void setOpenId(Object openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
