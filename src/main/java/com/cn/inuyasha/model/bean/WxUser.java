package com.cn.inuyasha.model.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信用户
 */
public class WxUser {
    private int id;
    private String nickname;
    private String fullname;
    private String mobile;
    private String openId;
    private int gender;
    private String province;
    private String city;
    private String country;
    private String head;

    public WxUser(JSONObject json) {
        if (json != null) {
            this.id = json.getIntValue("id");
            this.nickname = json.getString("nickname");
            this.fullname = json.getString("fullname");
            this.mobile = json.getString("mobile");
            this.openId = json.getString("openId");
            this.gender = json.getIntValue("gender");
            this.province = json.getString("province");
            this.city = json.getString("city");
            this.country = json.getString("country");
            this.head = json.getString("head");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
