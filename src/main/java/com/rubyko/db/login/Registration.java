package com.rubyko.db.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.rubyko.db.Database;

public class Registration {

	/**
	 * Add user into the database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public static int addUser(String token, String email, String pass, String userName)
			throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `RubykoDb`.`user` (`password`, `email`, `token`, `name`, `createTime`) VALUES ('111', '11', '11', '1', '1');";
		try (Connection conn = Database.getInstance().connect();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		}
	}
}
