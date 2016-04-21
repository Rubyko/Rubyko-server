package com.rubyko.db;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.SQLException;

public final class Database {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/RubykoDb";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "uven6559";


	private final static Database instance = new Database();

	public final static Database getInstance() {
		return instance;
	}

	private Database() {
	}

	public Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}


}
