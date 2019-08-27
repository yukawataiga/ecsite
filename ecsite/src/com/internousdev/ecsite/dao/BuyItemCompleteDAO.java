package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {
	DBConnector db = new DBConnector();
	Connection conn = db.getConnection();
	DateUtil date = new DateUtil();

	public void buyItemInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay) throws SQLException {

		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, date.getDate());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStock(int stock, String item_name) throws SQLException{

		String sql = "UPDATE item_info_transaction SET item_stock = ?, updated_date = ? where item_name = ?";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setString(2, date.getDate());
			ps.setString(3, item_name);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
}
