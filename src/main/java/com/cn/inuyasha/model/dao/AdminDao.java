package com.cn.inuyasha.model.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {

    /**
     * 查询管理员条数
     */
    int countAccount(JSONObject admin);

    /**
     * 查询管理员列表
     */
    List<JSONObject> selectAccountQuery(JSONObject admin);

    // 修改管理员
    int updateAdminUser(JSONObject admin);

    // 删除管理员
    int deleteAdminUser(int admin);

    // 查询登录用户
    JSONObject selectAdminUserByLogin(String login);

    // 通过ID查询管理信息
    JSONObject selectAdminUserById(int id);

    // 更新管理用户登录信息
    int updateAdminUserLogin(JSONObject login);

    // 统计管理员总数
    int selectAdminUserCount();

    // 添加管理员
    int insertAdminUser(JSONObject admin);


}
