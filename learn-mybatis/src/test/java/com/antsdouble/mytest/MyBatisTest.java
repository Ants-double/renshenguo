package com.antsdouble.mytest;

import com.antsdouble.bean.Employee;
import com.antsdouble.dao.EmployeeDynamicMapper;
import com.antsdouble.dao.EmployeeMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MyBatisTest
 * @Description t
 * @date 3/27/2019
 * @Author liyy
 * @Version 1.0
 */

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    /*
     1. 根据xml生成SqlSessionFactory
        有数据源运行环境的信息
     2. sql映射文件，配置了每个sql以及sql的封装规则
     3.将sql映射文件注册在全局配置文件中
     4.写代码
        1>根据全局配置文件得到SqlSessionFactory
        2>使用SqlSession工厂得到SqlSession
        3>SqlSession执行增删改查 这是非线程安全的
        4>用完要关掉
        5>使用sql的唯一标识告诉mybatis执行那个sql
    5.接口式编程
    6. 两个重要的配置文件
        mybatis全局配置文件 包含数据库的连接信息和事务管理器等信息，系统 级别的
        sql映射文件， 保存了每个sql语句的映射信息
     * @return void
     */
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取一个Sqlsession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            //唯一标识，sql参数 这是一个原生的方式不建议使用
            Employee employee = openSession.selectOne("com.antsdouble.mybatis.EmployeeMapper.selectEmp", "1");
            System.out.println(employee);
        } finally {
            openSession.close();

        }


    }

    @Test
    public void test01() throws IOException {

        //获取sqlsessionfactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取一个sqlSession
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象
            EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
            //会为接口创建一个代理对象
            Employee employee = employeeMapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }
    @Test
    public void  test03() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取到的sqlSession不会自动提交
        //SqlSession openSession = sqlSessionFactory.openSession(true); 自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null,"gf", "fg@ants.com", "0");
            mapper.addEmp(employee);
            System.out.println(employee);
            openSession.commit();//手动提交
        }
        finally {
            openSession.close();
        }

    }



    @Test
    public void  getEmpByIdAndLastNameTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
           // Employee employee = mapper.getEmpByIdAndLastName(@Param("id") Integer 1, @Param("lastName")String "tom");
           // Employee employee = mapper.getEmpByIdAndLastName( 1, "tom");

           // Employee empByIdAndDept = mapper.getEmpByIdAndDept(1);
            Employee empByIdStep = mapper.getEmpByIdStep(1);

            System.out.println(empByIdStep);
        }
        finally {
            openSession.close();
        }
    }

    @Test
    public  void  getEmpByConditionTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            EmployeeDynamicMapper mapper = openSession.getMapper(EmployeeDynamicMapper.class);
            Employee employee = new Employee(null, null, null, null);
           // List<Employee> empByCondition = mapper.getEmpByCondition(employee);
            List<Employee> empByCondition = mapper.getEmpByConditionChoose(employee);

            for (Employee emp :empByCondition){
                System.out.println(emp);
            }
            //System.out.println(empByCondition);
        }
        finally {
            openSession.close();
        }
    }

    @Test
    public  void  getEmpByConditionForeachTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            EmployeeDynamicMapper mapper = openSession.getMapper(EmployeeDynamicMapper.class);
            List<Employee> empByCondition = mapper.getEmpByConditionForeach(Arrays.asList(1,2,3));

            for (Employee emp :empByCondition){
                System.out.println(emp);
            }
        }
        finally {
            openSession.close();
        }
    }
}
