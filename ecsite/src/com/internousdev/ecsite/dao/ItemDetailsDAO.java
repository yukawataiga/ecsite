package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailsDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private ItemInfoDTO dto = new ItemInfoDTO();

	public ItemInfoDTO createInfo(int Id) throws SQLException{
		String sql = "SELECT * FROM item_info_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
