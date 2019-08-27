package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private int id, item_stock;
	private String itemName;
	private String itemPrice;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}
}
