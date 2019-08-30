package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	BuyItemDAO dao = new BuyItemDAO();
	private ArrayList<BuyItemDTO> itemList = new ArrayList<>();

	public String execute() throws SQLException {
		String result = "login";
		if(session.containsKey("login_user_id")) {
			result = SUCCESS ;
		}
		if(session.containsKey("admin_flg")) {
			result = "admin";
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public ArrayList<BuyItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<BuyItemDTO> itemList) {
		this.itemList = itemList;
	}
}
