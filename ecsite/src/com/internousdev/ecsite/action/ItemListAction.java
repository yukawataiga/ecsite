package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	ArrayList<ItemInfoDTO> ItemList = new ArrayList<>();

	public String execute() throws SQLException{
		ItemListDAO dao = new ItemListDAO();

		//商品の情報をItemListに詰め込む
		ItemList = dao.ItemInfo();

		//itemList.jspに飛ぶ
		return SUCCESS ;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return ItemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.ItemList = itemList;
	}
}
