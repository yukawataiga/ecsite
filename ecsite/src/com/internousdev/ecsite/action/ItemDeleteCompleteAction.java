package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String Message;

	public String execute() throws SQLException{
		ItemDeleteCompleteDAO dao = new ItemDeleteCompleteDAO();
		dao.deleteItem(Integer.parseInt(session.get("Id").toString()));
		Message = "商品ID"+session.get("Id")+"を削除しました";
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String Message) {
		this.Message = Message;
	}
}
