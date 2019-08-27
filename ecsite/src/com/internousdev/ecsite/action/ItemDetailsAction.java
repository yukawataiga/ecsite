package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware{

	private String Id;
	public Map<String, Object> session;
	private ItemInfoDTO itemInfo = new ItemInfoDTO();

	public String execute() throws SQLException{

		int id = Integer.parseInt(Id);
		ItemDetailsDAO dao = new ItemDetailsDAO();
		itemInfo = dao.createInfo(id);

		session.put("itemInfo", itemInfo);
		session.put("Id",Id);
		return SUCCESS;
	}

	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public ItemInfoDTO getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfoDTO itemInfo) {
		this.itemInfo = itemInfo;
	}
}
