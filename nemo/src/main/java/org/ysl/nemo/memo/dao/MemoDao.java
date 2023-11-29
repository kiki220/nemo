package org.ysl.nemo.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.ysl.nemo.memo.domain.DelVo;
import org.ysl.nemo.memo.domain.DetailVo;
import org.ysl.nemo.memo.domain.LoginVo;
import org.ysl.nemo.memo.domain.NewVo;
import org.ysl.nemo.memo.domain.TodoVo;

@Mapper
public interface MemoDao {
    List<TodoVo> selectAll(LoginVo loginVo);

    int delete(DelVo delVo);
    
    int insert(NewVo newVo);
    
    String login(LoginVo loginVo);
    
    List<DetailVo> selectDetail(DetailVo detailVo);
    
    int deletedetail(DelVo delVo);
    
    int insertdetail(NewVo newVo);
}
