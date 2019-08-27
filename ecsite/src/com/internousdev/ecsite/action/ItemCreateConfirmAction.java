package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String item_name, item_price, item_stock;
	private int intPrice, intStock;
	private String errorMessage;
	public Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;
		//未記入かどうかを判別

		if(!(item_name.equals(""))
			&& !(item_price.equals(""))
			&& !(item_stock.equals(""))) {
			//価格、個数が数字かどうかを判別
			try{
				setIntPrice(Integer.parseInt(item_price));
				setIntStock(Integer.parseInt(item_stock));
			}catch(NumberFormatException e){
				setErrorMessage("価格、個数は数字で記入してください");
				result = ERROR;
			}
			//セッションにプットする
			session.put("item_name", item_name);
			session.put("item_price", item_price);
			session.put("item_stock", item_stock);
		//未記入の場合、errorを返して、itemCreate.jspに返す
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR ;
		}
		//successのときitemCreateConfirm.jspに飛ぶ
		return result;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_price() {
		return item_price;
	}
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public String getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(String item_stock) {
		this.item_stock = item_stock;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public int getIntStock() {
		return intStock;
	}
	public void setIntStock(int intStock) {
		this.intStock = intStock;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
