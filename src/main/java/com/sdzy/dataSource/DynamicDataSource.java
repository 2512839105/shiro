package com.sdzy.dataSource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	 
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);//设置默认数据源
        super.setTargetDataSources(new HashMap<Object, Object>(targetDataSources));//设置数据源
        super.afterPropertiesSet();//判断 动态数据源 和默认数据源是否为空  将其加入到
    }
 
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
 
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }
 
    public static String getDataSource() {
        return contextHolder.get();
    }
 
    public static void clearDataSource() {
        contextHolder.remove();
    }
}
