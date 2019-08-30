package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements SessionAware{
	private String[] orderCount = new String[100];
	private Map<String, Object> session;

	public String execute() {
		ArrayList<ItemInfoDTO> itemList = (ArrayList<ItemInfoDTO>) session.get("itemList");
		boolean flag = true;
		int i=0;

		while(flag){
			if(orderCount[i].equals("")){
				orderCount[i] = "0";
			}
			itemList.get(i).setOrderCount(Integer.parseInt(orderCount[i]));

			i++;
			if(orderCount[i] == null){
				flag = false;
			}
		}
		session.put("itemList", itemList);
		return SUCCESS;
	}

	public String[] getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String[] orderCount) {
		this.orderCount = orderCount;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
