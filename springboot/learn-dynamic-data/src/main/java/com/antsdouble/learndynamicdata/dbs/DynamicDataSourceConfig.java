package com.antsdouble.learndynamicdata.dbs;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DynamicDataSourceConfig
 * @Description d
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.antsdouble.learndynamicdata.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DynamicDataSourceConfig {

    @Bean(name = "antsdouble")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource antsdouble(){
        return getDataSource();
    }

    @Bean(name = "antsdouble1")
    @ConfigurationProperties(prefix = "custom.datasource.antsdouble1")
    public DataSource antsdouble1(){
        return getDataSource();
    }


    @Bean(name = "dataSource")
    @Primary
    public  DynamicDataSource dataSource(@Qualifier("antsdouble") DataSource antsdouble,@Qualifier("antsdouble1") DataSource antsdouble1){
        Map<Object,Object> targetDataSources=new HashMap<Object,Object>();
        targetDataSources.put("antsdouble", antsdouble);
        targetDataSources.put("antsdouble1",antsdouble1);

        DynamicDataSourceContextHolder.addDataSourceKey("antsdouble");
        DynamicDataSourceContextHolder.addDataSourceKey("antsdouble1");

        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);

        dynamicDataSource.setDefaultTargetDataSource(antsdouble);//设为默认

        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("antsdouble") DataSource antsdouble,@Qualifier("antsdouble1") DataSource antsdouble1) throws Exception {
        SqlSessionFactoryBean bean =new SqlSessionFactoryBean();
        bean.setDataSource(this.dataSource(antsdouble,antsdouble1));
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
        return bean.getObject();

    }


    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DynamicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory)  {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    private DataSource getDataSource() {
        DruidDataSource druidDataSource = (DruidDataSource) DruidDataSourcePool.getDruidDataSource();
        List filterList = new ArrayList<>();
        filterList.add(wallFilter());
        druidDataSource.setProxyFilters(filterList);
        return druidDataSource;
    }



    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }


    @Bean
    public WallConfig wallConfig(){
        WallConfig config=new WallConfig();
        config.setMultiStatementAllow(true);
        config.setNoneBaseStatementAllow(true);
        return config;
    }
}
