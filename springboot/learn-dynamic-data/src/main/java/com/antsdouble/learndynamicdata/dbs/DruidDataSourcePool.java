package com.antsdouble.learndynamicdata.dbs;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @ClassName DruidDataSourcePool
 * @Description t
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
public class DruidDataSourcePool {
    public static DataSource getDruidDataSource(){
        return  new DruidDataSource();
    }
}
