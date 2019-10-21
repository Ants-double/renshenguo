package com.antsdouble.learndynamicdata.dbs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName DynamicDataSourceAspect
 * @Description d
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource){
        //获取当前指定的数据源ID
        String dataSourceId = targetDataSource.value();

        if(DynamicDataSourceContextHolder.containsDataSource(dataSourceId)){
            System.out.println("当前使用数据源：{} > {}" + targetDataSource.value() + point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceKey(dataSourceId);
        }else{
            System.err.println("数据源[{}]不存在，使用默认数据源 > {}"+targetDataSource.value()+point.getSignature());
        }
    }


    @After("@annotation(targetDataSource)")
    public void clearDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        System.out.println("重置数据源 DataSource : {} > {}" + targetDataSource.value() + point.getSignature());
        // 方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }
}
