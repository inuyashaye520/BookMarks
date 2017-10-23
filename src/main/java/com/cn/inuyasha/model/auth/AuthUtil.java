package com.cn.inuyasha.model.auth;

import com.cn.inuyasha.model.bean.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;

import javax.servlet.http.HttpServletRequest;

/**
 * Wx auth util
 */
public class AuthUtil {

    public static String getOpenId(HttpServletRequest request, String callback) {
        try {
            Principal principal = (Principal) SecurityUtils.getSubject().getPrincipal();
            return (String) principal.getOpenId();
        } catch (Exception e) {
            request.setAttribute("WxLoginCallback", callback);
            throw new AuthorizationException(e);
        }
    }

}
