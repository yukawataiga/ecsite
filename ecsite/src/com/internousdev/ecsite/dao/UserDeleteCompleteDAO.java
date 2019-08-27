package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public void deleteUser(int Id) throws SQLException {
		String sql = "DELETE FROM login_user_transaction where Id = ?";

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);

			ps.execute();
		}catch(Exception e) {
		e.printStackTrace();
		}finally{
			con.close();
		}
		return;
	}
}
