package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{
	ArrayList<UserInfoDTO> userList = new ArrayList<>();

	public String execute() throws SQLException {
		UserListDAO dao = new UserListDAO();

		//ユーザー情報のリスト化
		userList = dao.userInfo();

		//userList.jspに飛ぶ
		return SUCCESS;
	}

	public ArrayList<UserInfoDTO> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}
}
