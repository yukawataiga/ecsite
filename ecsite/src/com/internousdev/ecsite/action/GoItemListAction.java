package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	BuyItemDAO dao = new BuyItemDAO();
	private ArrayList<BuyItemDTO> itemList = new ArrayList<>();
	private Map<String, String> priceList = new HashMap<>();
	private String checkFlg;

	public String execute() throws SQLException {
		String result = ERROR;
		itemList = dao.getBuyItemList();
		session.put("dto",itemList);
		session.put("buyItemList", itemList);


		for(BuyItemDTO dto:itemList){
			priceList.put(String.valueOf(dto.getId()), dto.getItemPrice());
		}
		session.put("priceList", priceList);

		switch(checkFlg) {
		case "pullDown":
			result =checkFlg;
			break;
		case "list":
			result =checkFlg;
			break;
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<BuyItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<BuyItemDTO> itemList) {
		this.itemList = itemList;
	}


	public String getCheckFlg() {
		return checkFlg;
	}

	public void setCheckFlg(String checkFlg) {
		this.checkFlg = checkFlg;
	}

	public Map<String, String> getPriceList() {
		return priceList;
	}

	public void setPriceList(Map<String, String> priceList) {
		this.priceList = priceList;
	}


}
