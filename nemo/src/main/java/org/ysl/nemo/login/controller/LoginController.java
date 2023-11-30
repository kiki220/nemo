package org.ysl.nemo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ysl.nemo.login.service.LoginService;
import org.ysl.nemo.memo.domain.LoginVo;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @GetMapping("/login")
    public String loginview() {
        return "login/html/login.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginVo loginVo, HttpSession session) {
        return loginService.login(loginVo, session);
    }
    
    @GetMapping("/logout")
    @ResponseBody
    public void logout(HttpSession session) {
        session.invalidate();
    }
    
    @GetMapping("/chkloginid")
    @ResponseBody
    public String chkloginid(HttpSession session) {
        return (String)session.getAttribute("userID");
    }
}
