package com.antsdouble.demojwt.dao;

import com.antsdouble.demojwt.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}

