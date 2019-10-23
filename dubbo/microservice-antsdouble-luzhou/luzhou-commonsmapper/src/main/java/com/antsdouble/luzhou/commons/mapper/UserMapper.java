package com.antsdouble.luzhou.commons.mapper;

import com.antsdouble.luzhou.commons.domain.User;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
 * @author antsdouble
 */
public interface UserMapper extends MyMapper<User> {

    @Override
    List<User> selectAll();
}