package org.ysl.nemo.login.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ysl.nemo.login.dao.LoginDao;
import org.ysl.nemo.memo.domain.LoginVo;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private LoginDao loginDao;

    @Override
    public String login(LoginVo loginVo, HttpSession session) {
        String loginyn = loginDao.login(loginVo);
        if("Y".equals(loginyn)) {
            session.setAttribute("userID",loginVo.getUserid());
            
        }
        
        return loginyn;
    }

}
