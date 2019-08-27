package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailsDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private UserInfoDTO dto = new UserInfoDTO();

	public UserInfoDTO createInfo(int Id) throws SQLException{
		String sql = "SELECT * FROM login_user_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setLogin_id(rs.getString("login_id"));
				dto.setLogin_pass(rs.getString("login_pass"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
