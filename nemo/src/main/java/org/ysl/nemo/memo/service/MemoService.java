package org.ysl.nemo.memo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ysl.nemo.memo.domain.DelVo;
import org.ysl.nemo.memo.domain.DetailVo;
import org.ysl.nemo.memo.domain.LoginVo;
import org.ysl.nemo.memo.domain.NewVo;
import org.ysl.nemo.memo.domain.TodoVo;

public interface MemoService {
    List<TodoVo> list(LoginVo loginVo);

    int del(DelVo delVo);
    
    int ins(NewVo newVo);
    
    List<DetailVo> detaillist(DetailVo detailVo);
    
    int deldetail(DelVo delVo);
    
    int insdetail(NewVo newVo);
}
