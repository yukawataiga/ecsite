package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil date = new DateUtil();
	//名前、価格、個数、日付を挿入する
	private String sql = "INSERT INTO item_info_transaction(item_name, item_price, item_stock, insert_date)"
			+ " VALUES(?,?,?,?)";

	public void createItem(String item_name, int item_price, int item_stock) throws SQLException{

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item_name);
			ps.setInt(2, item_price);
			ps.setInt(3, item_stock);
			ps.setString(4, date.getDate());

			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
