package org.ysl.nemo.login.service;

import javax.servlet.http.HttpSession;

import org.ysl.nemo.memo.domain.LoginVo;

public interface LoginService {
    String login(LoginVo loginVo, HttpSession session);
}
