package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemListDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	//DB item_info_transaction から商品ID、名前、価格、在庫、日付を取得するSQL文
	private String sql = "SELECT id, item_name, item_price, item_stock, insert_date FROM item_info_transaction";

	public ArrayList<ItemInfoDTO> ItemInfo() throws SQLException {
		ArrayList<ItemInfoDTO> ItemList = new ArrayList<>();
		try {

			//SQL文の実行を結果の保存
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//結果がなくなるまでdtoの各項目に取得した値をインプット
			while(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				ItemList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
		//完成したリストを返す。
		return ItemList;
	}
}
