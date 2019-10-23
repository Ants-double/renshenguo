package com.antsdouble.luzhou.service.content.provider.api.impl;

import com.antsdouble.content.api.UserServer;
import com.antsdouble.luzhou.commons.domain.User;
import com.antsdouble.luzhou.commons.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/23
 */
@Service(version = "${services.versions.content.v1}")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }
}
