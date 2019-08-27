package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {
	private String Message;

	public String execute() throws SQLException {
		ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

		//deleteListで消した件数を保存する。
		int count = dao.deleteList();

		setMessage(count+"件削除されました");
		//itemListDeleteComplete.jspに飛ぶ
		return SUCCESS;
	}

	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		this.Message = message;
	}
}
