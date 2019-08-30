package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class OrderDAO {
	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();
	private DateUtil date = new DateUtil();

	public void updateStockCount(int Id, int stock) throws SQLException {

		String sql = "UPDATE item_info_transaction set item_stock = ?, updated_date = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setString(2, date.getDate());
			ps.setInt(3, Id);

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
