package com.cs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBManager {
	private static final Logger LOGGER = LogManager.getLogger(DBManager.class);
	
	public Connection getDBConn() {
		Connection dbConn = null;
	    try {
	        Class.forName("org.hsqldb.jdbcDriver");
	        dbConn = DriverManager.getConnection(
	                "jdbc:hsqldb:file:C:/EventDbCreation/HSQLDB/DB", "SA", "");
	    }catch (ClassNotFoundException | SQLException e) {
	    	LOGGER.error("Exception while gettign connection" ,e);
	    }    
	    return dbConn;
	}
}
