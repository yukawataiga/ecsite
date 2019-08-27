package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.CreateHash;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();
		String userName = null;

		String sql = "SELECT user_name FROM login_user_transaction WHERE login_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userName = rs.getString("user_name");
			}
			dto = confirmHashPass(loginUserId, loginPassword, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public LoginDTO confirmHashPass(String id, String inputPass,
			String userName) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();
		CreateHash hash = new CreateHash();

		String sql = "SELECT  login_id, user_name, admin_flg FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";
		String hashPass = null;

		hashPass = hash.getSafetyPassword(inputPass, userName);
		hashPass = hash.getSafetyPassword(hashPass, userName);
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, hashPass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setLoginId(rs.getString("login_id"));
				dto.setUserName(rs.getString("user_name"));

				if (rs.getString("login_id") != null) {
					dto.setLoginFlg(true);
				}

				if (rs.getString("admin_flg") != null) {
					dto.setAdminFlg("1");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
