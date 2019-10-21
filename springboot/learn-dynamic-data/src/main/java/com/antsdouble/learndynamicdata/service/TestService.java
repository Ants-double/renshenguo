package com.antsdouble.learndynamicdata.service;

import com.antsdouble.learndynamicdata.dbs.TargetDataSource;
import com.antsdouble.learndynamicdata.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @Description t
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
@Service("testService")
public class TestService {

    @Autowired
    private DataMapper dataMapper;


    @TargetDataSource("antsdouble")
    public String getTest1(){
        return dataMapper.getData();
    }

    @TargetDataSource("antsdouble1")
    public String getTest2(){
        return  dataMapper.getData2();
    }

}
