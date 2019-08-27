package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	public int deleteList() throws SQLException {
		String sql = "SELECT login_id FROM login_user_transaction where admin_flg IS NULL";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			deleteBuyList(rs);
			count = deleteUserList();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return count;
	}

	public void deleteBuyList(ResultSet rs) throws SQLException{
		String sql = "DELETE FROM user_buy_item_transaction where user_master_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			while(rs.next()){
			ps.setString(1, rs.getString("login_id"));
			ps.execute();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int deleteUserList() throws SQLException{
		String sql = "DELETE FROM login_user_transaction where admin_flg IS NULL";
		int count = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			count = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
