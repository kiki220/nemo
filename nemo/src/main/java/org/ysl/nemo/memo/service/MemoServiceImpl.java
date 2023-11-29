package org.ysl.nemo.memo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ysl.nemo.memo.dao.MemoDao;
import org.ysl.nemo.memo.domain.DelVo;
import org.ysl.nemo.memo.domain.DetailVo;
import org.ysl.nemo.memo.domain.LoginVo;
import org.ysl.nemo.memo.domain.NewVo;
import org.ysl.nemo.memo.domain.TodoVo;

@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoDao memoDao;

    @Override
    public List<TodoVo> list(LoginVo loginVo) {
        return memoDao.selectAll(loginVo);
    }

    @Override
    public int del(DelVo delVo) {
        return memoDao.delete(delVo);
    }
    
    @Override
    public int ins(NewVo newVo) {
        return memoDao.insert(newVo);
    }

    @Override
    public String login(LoginVo loginVo, HttpSession session) {
        String loginyn = memoDao.login(loginVo);
        if("Y".equals(loginyn)) {
            session.setAttribute("userID",loginVo.getUserid());
            
        }
        
        /*
         * if(loginyn == 'Y'){ var link = 'http://localhost:8090/';
         * location.replace(link); } else{ alert("로그인정보가 존재하지 않습니다."); return; }
         */
        
        return loginyn;
    }

    @Override
    public boolean loginchk(HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return true;
        }else {return false;}
        
    }
    
    @Override
    public List<DetailVo> detaillist(DetailVo detailVo) {
        return memoDao.selectDetail(detailVo);
    }
    
    @Override
    public int deldetail(DelVo delVo) {
        return memoDao.deletedetail(delVo);
    }
    
    @Override
    public int insdetail(NewVo newVo) {
        return memoDao.insertdetail(newVo);
    }
}
