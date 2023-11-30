package org.ysl.nemo.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.ysl.nemo.memo.domain.LoginVo;

@Mapper
public interface LoginDao {
    String login(LoginVo loginVo);
}
