package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.OrderDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OrderCompleteAction extends ActionSupport implements SessionAware{
	OrderDAO dao = new OrderDAO();
	Map<String, Object> session;

	public String execute() throws SQLException {
		ArrayList<ItemInfoDTO> itemList = (ArrayList<ItemInfoDTO>) session.get("itemList");

		for(ItemInfoDTO list : itemList){
			int stock = list.getItem_stock() + list.getOrderCount();
			dao.updateStockCount(list.getId(), stock);
		}

		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
