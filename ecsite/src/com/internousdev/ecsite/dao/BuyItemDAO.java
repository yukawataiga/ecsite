package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();

	public BuyItemDTO getBuyItemInfo() {
		BuyItemDTO dto = new BuyItemDTO();
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public BuyItemDTO getBuyItemConfirmInfo(int id) {
		BuyItemDTO dto = new BuyItemDTO();
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList<BuyItemDTO> getBuyItemList() throws SQLException {
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction";
		ArrayList<BuyItemDTO> itemList = new ArrayList<>();

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				BuyItemDTO dto = new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				itemList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}

}
