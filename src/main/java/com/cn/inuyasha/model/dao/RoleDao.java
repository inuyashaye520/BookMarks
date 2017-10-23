package com.cn.inuyasha.model.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    /**
     * 添加角色
     */
    int insert(JSONObject json);

    /**
     * 保存用户权限
     */
    int insertUserRole(JSONObject data);

    /**
     * 修改角色
     */
    int update(JSONObject json);

    /**
     * 删除用户权限
     */
    int deleteUserRole(JSONObject data);

    /**
     * 删除角色
     */
    int delete(int id);

    /**
     * 获取角色下面的用户ID
     */
    List<Integer> selectByRoleId(int id);

    /**
     * 获取所有角色
     */
    List<JSONObject> selectAll();

    /**
     * 获取用户拥有的角色
     */
    List<Integer> selectByUserId(int userId);

    /**
     * 通过用户ID删除用户角色
     */
    int deleteUserRoleByUserId(int userId);


}
