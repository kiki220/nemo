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
