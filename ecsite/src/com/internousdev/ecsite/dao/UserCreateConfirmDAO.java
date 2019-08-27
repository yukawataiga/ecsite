package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	ArrayList<String> idList = new ArrayList<>();

	public ArrayList<String> getID() throws SQLException{
		String sql = "Select login_id FROM login_user_transaction";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				idList.add(rs.getString("login_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return idList;
	}

	public void pendingUser(String pass) throws SQLException{
		String sql = "INSERT INTO login_user_transaction (login_pass, pending) VALUES(?,?)";
		try{
			PreparedStatement ps= con.prepareStatement(sql);

			ps.setString(1, pass);
			ps.setString(2, "1");
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePendingUser(String pass) throws SQLException {
		String sql = "DELETE FROM login_user_transaction where login_pass = ? AND pending = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, pass);
			ps.setString(2, "1");
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
