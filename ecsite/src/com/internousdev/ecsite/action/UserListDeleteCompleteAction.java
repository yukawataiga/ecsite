package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	private String Message;

	public String execute() throws SQLException {
		UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();

		//deleteListで消した件数を保存する。
		int count = dao.deleteList();

		setMessage(count+"件削除されました");

		return SUCCESS;//userListDeleteComplete.jspに飛ぶ
	}

	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		this.Message = message;
	}
}
