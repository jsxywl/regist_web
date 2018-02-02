package com.imooc.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	public static DataSource getDataSource(){
		 // �������ӳغ��Ĺ�����  
        try {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();  
			// �������Ӳ�����url���������û����롢��ʼ�����������������  
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/regist_web");  
			dataSource.setDriverClass("com.mysql.jdbc.Driver");  
			dataSource.setUser("root");  
			dataSource.setPassword("root");  
			dataSource.setInitialPoolSize(3);  
			dataSource.setMaxPoolSize(6);  
			dataSource.setMaxIdleTime(1000); 
			return dataSource;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
