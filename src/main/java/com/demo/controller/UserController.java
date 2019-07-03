package com.demo.controller;

import com.demo.common.pojo.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public String login(UserBean userBean) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUsername(), userBean.getPassword());

        try {
            token.setRememberMe(userBean.isRememberMe());
            subject.login(token);
        }catch (AuthenticationException e) {
            return e.getMessage();
        }
        return "登录成功！";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "登出成功！";
    }

    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @RequiresRoles(value = {"admin"})
    public String testRole() {
        return "have role";
    }
}
