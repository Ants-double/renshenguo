package com.antsdouble.learndynamicdata.dbs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DynamicDataSourceContextHolder
 * @Description t
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();


    private static List<String> dataSourceKeys = new ArrayList<String>();

    public static void addDataSourceKey(String dataSourceKey) {
        dataSourceKeys.add(dataSourceKey);
    }

    public static String setDataSourceKey() {
        return contextHolder.get();
    }


    public static String getDataSourceKey(){
        return contextHolder.get();
    }
    public static void clearDataSourceKey(){
        contextHolder.remove();
    }

    public static void setDataSourceKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceKeys.contains(dataSourceId);
    }

}
