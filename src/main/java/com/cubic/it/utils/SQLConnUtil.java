package com.cubic.it.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/happy_hrs_db";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="mysql@1234";
	
	public static Connection getConnection() throws Exception{
		//Loading the Driver
		Class.forName(DRIVER);
		//Creating connection
		Connection connection=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		return connection;
	}

}
