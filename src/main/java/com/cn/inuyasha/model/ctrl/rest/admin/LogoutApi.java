package com.cn.inuyasha.model.ctrl.rest.admin;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("logoutApi")
public class LogoutApi {

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

}
