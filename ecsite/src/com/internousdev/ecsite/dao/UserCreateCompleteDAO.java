package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();
	private DateUtil date = new DateUtil();

	public void createUser(String loginUserId, String loginUserPassword,
			String userName) throws SQLException {

		String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date)"
				+ " VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, date.getDate());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePendingUser(String pass) throws SQLException {
		String sql = "DELETE FROM login_user_transaction WHERE login_pass = ? AND pending = ?";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, "1");

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
