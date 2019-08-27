package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String item_name;
	private int item_price, item_stock;
	public Map<String, Object> session;
	private ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		//商品の名前をString型に、価格と個数をint型にObject型から変換してdao渡す。
		dao.createItem(
				session.get("item_name").toString(),
				Integer.parseInt(session.get("item_price").toString()),
				Integer.parseInt(session.get("item_stock").toString()));
		//エラー表記がでなかったら、itemCreateComplete.jspに飛ぶ。
		return SUCCESS;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}
