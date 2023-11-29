package org.ysl.nemo.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ysl.nemo.memo.domain.DelVo;
import org.ysl.nemo.memo.domain.DetailVo;
import org.ysl.nemo.memo.domain.LoginVo;
import org.ysl.nemo.memo.domain.NewVo;
import org.ysl.nemo.memo.domain.TodoVo;
import org.ysl.nemo.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemoApiController {
    /*
     * 2. 상식선에서 이해가 가능하도록 꾸미기 (화면이든 기능이든)
     * 3. 면접 공부랑 이 프로젝트 뜯어보기가 좀 중요할듯 (기본기)
     * */

    @Autowired
    private MemoService memoService;

    @GetMapping("/list")
    public List<TodoVo> list(HttpSession session) {
        if(loginchk(session)) {
            LoginVo loginVo = new LoginVo();
            loginVo.setUserid((String)session.getAttribute("userID"));
            return memoService.list(loginVo);
        }else {return null;}
    }

    @PostMapping("/del")
    public void del(@RequestBody DelVo delVo, HttpSession session) {
        if(loginchk(session)) {
            delVo.setUserid((String)session.getAttribute("userID"));
            memoService.del(delVo);
        }else {return;}
        
    }
    
    @PostMapping("/ins")
    public void ins(@RequestBody NewVo newVo, HttpSession session) {
        if(loginchk(session)) {
            newVo.setUserid((String)session.getAttribute("userID"));
            memoService.ins(newVo);
        }else {return;}
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginVo loginVo, HttpSession session) {
        return memoService.login(loginVo, session);
    }
    
    public boolean loginchk(HttpSession session) {
        return memoService.loginchk(session);
    }
    
    @GetMapping("/logout")
    public void logout(HttpSession session) {
        log.info((String)session.getAttribute("userID"));
        session.invalidate();
    }
    
    @GetMapping("/detail")
    public List<DetailVo> detaillist(@RequestParam int titleno,HttpSession session) {
        if(loginchk(session)) {
            DetailVo detailVo = new DetailVo();
            detailVo.setTitleno(titleno);
            detailVo.setUserid((String)session.getAttribute("userID"));
            return memoService.detaillist(detailVo);
        }else {return null;}
    }
    
    @PostMapping("/deldetail")
    public void deldetail(@RequestBody DelVo delVo, HttpSession session) {
        if(loginchk(session)) {
            delVo.setUserid((String)session.getAttribute("userID"));
            memoService.deldetail(delVo);
        }else {return;}
        
    }
    
    @PostMapping("/insdetail")
    public void insdetail(@RequestBody NewVo newVo, HttpSession session) {
        if(loginchk(session)) {
            newVo.setUserid((String)session.getAttribute("userID"));
            memoService.insdetail(newVo);
        }else {return;}
    }
    
    @GetMapping("/chkloginid")
    public String chkloginid(HttpSession session) {
        return (String)session.getAttribute("userID");
    }
}
