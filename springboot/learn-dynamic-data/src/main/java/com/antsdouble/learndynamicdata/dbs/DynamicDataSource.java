package com.antsdouble.learndynamicdata.dbs;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName DynamicDataSource
 * @Description d
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}
