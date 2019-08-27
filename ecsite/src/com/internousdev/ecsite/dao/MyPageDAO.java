package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id)
	throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SElECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date"
				+ " FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit"
				+ " ON ubit.item_transaction_id = iit.id"
				+ " WHERE ubit.user_master_id = ?"
				+ " ORDER BY insert_date DESC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String user_master_id) throws SQLException {
		String sql = "DELETE FROM user_buy_item_transaction"
				+ " WHERE user_master_id = ?";
		int result = 0;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return result;
	}
}
