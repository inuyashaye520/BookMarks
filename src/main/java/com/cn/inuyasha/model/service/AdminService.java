package com.cn.inuyasha.model.service;

import com.alibaba.fastjson.JSONObject;
import com.cn.inuyasha.model.bean.Pageable;
import com.cn.inuyasha.model.dao.AdminDao;
import com.cn.inuyasha.model.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service("adminService")
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    @Qualifier("transactionManager")
    private DataSourceTransactionManager tm;

    @Autowired
    @Qualifier("transactionDefinition")
    private DefaultTransactionDefinition td;

    /**
     * admin用户列表
     *
     * @param json     查询条件
     * @param page     页数
     * @param pageSize 每页显示个数
     * @return admin用户数据列表
     */
    public Pageable<JSONObject> queryAccount(JSONObject json, int page, int pageSize) {
        int total = adminDao.countAccount(json);
        Pageable<JSONObject> result = new Pageable<>(total, pageSize, page);
        json.put("start", result.getStart());
        json.put("pageSize", pageSize);
        result.setItems(adminDao.selectAccountQuery(json));
        return result;
    }

    /**
     * 新增Admin用户
     *
     * @param json admin用户信息
     * @return 新增admin用户ID
     */
    public Integer addAccount(JSONObject json) {
        String password = json.getString("password");
        if (password != null) {
            json.put("password", DigestUtils.sha1DigestAsHex(password));
        }
        adminDao.insertAdminUser(json);
        return json.getInteger("id");
    }

    /**
     * 修改管理员用户信息
     *
     * @param admin 账号信息
     * @return 成功与否
     */
    public boolean updateAdminUser(JSONObject admin) {
        String password = admin.getString("password");
        if (password != null) {
            admin.put("password", DigestUtils.sha1DigestAsHex(password));
        }
        return adminDao.updateAdminUser(admin) > 0;
    }

    /**
     * 删除管理员
     *
     * @param id 管理员信息
     * @return 成功与否
     */
    public boolean deleteAdminUser(int id) {
        return adminDao.deleteAdminUser(id) > 0;
    }

    /**
     * 通过登录信息获取管理员账号信息
     *
     * @param login 用户名或手机号
     * @return 管理员账号信息
     */
    public JSONObject getAdminUserByLogin(String login) {
        return adminDao.selectAdminUserByLogin(login);
    }

    /**
     * 获取管理员用户信息
     *
     * @param id 账号ID
     * @return 账号信息
     */
    public JSONObject selectAdminUserById(int id) {
        JSONObject admin = adminDao.selectAdminUserById(id);
        return admin;
    }

    /**
     * 更新登录信息
     */
    public boolean updateAdminUserLogin(JSONObject log) {
        return adminDao.updateAdminUserLogin(log) > 0;
    }

    @EventListener
    public void handApplicationReadyEvent(ApplicationReadyEvent event) {
        //默认初始化一个管理员账号
        if (adminDao.selectAdminUserCount() == 0) {
            TransactionStatus ts = tm.getTransaction(td);
            try{
                JSONObject admin = new JSONObject();
                admin.put("fullname", "Administrator");
                admin.put("username", "admin");
                admin.put("password", DigestUtils.sha1DigestAsHex("admin"));
                adminDao.insertAdminUser(admin);

                JSONObject role = new JSONObject();
                role.put("name", "系统管理员");
                role.put("assets", "旅游订单管理,旅游产品列表,旅游产品添加,旅游产品修改,旅游产品删除,包车订单管理," +
                        "包车产品列表,包车产品添加,包车产品修改,包车产品删除,商城订单管理,商城产品分类管理,商城产品列表," +
                        "商城产品添加,商城产品修改,商城产品删除,旅游对账管理,定制服务对账管理,包车对账管理,商城对账管理," +
                        "微信横幅列表,微信横幅添加,微信横幅修改,微信横幅删除,定制服务管理,投诉建议管理,用户管理,推广统计,账号列表," +
                        "账号添加,账号修改,账号删除,权限管理,参数设置");
                roleDao.insert(role);

                int userId = admin.getIntValue("id");
                int roleId = role.getIntValue("id");

                JSONObject userRole = new JSONObject();
                userRole.put("userId", userId);
                userRole.put("roleId", roleId);
                roleDao.insertUserRole(userRole);
                tm.commit(ts);
            } catch (Exception e) {
                e.printStackTrace();
                tm.rollback(ts);
            }
        }
    }
}
