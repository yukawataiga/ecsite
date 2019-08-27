package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	//DB login_user_transactionからid, ユーザーid, パスワード, 名前, 日付の取得
	private String sql = "SELECT id, login_id, login_pass, user_name, insert_date, admin_flg FROM login_user_transaction";

	public ArrayList<UserInfoDTO> userInfo() throws SQLException{
		ArrayList<UserInfoDTO> userList = new ArrayList<>();

		try {

			//SQL文の実行を結果の保存
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//結果がなくなるまでdtoの各項目に取得した値をインプット
			while(rs.next()){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setAdmin_flg(rs.getString("admin_flg"));
				dto.setLogin_id(rs.getString("login_id"));
				dto.setLogin_pass(rs.getString("login_pass"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				userList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
		//完成したリストを返す。
		return userList;
	}
}
