package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	ArrayList<ItemInfoDTO> ItemList = new ArrayList<>();
	private Map<String, Object> session;


	public String execute() throws SQLException{
		ItemListDAO dao = new ItemListDAO();

		//商品の情報をItemListに詰め込む
		ItemList = dao.ItemInfo();
		session.put("itemList", ItemList);

		//itemList.jspに飛ぶ
		return SUCCESS ;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return ItemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.ItemList = itemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
