package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private String sql = "DELETE FROM item_info_transaction";

	public int deleteList() throws SQLException {
		int rs = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return rs;
	}
}
