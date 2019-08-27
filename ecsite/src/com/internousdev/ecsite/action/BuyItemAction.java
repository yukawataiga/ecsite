package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private int count;
	private String pay;
	private String errorMessage;
	private String id;
	private BuyItemDTO dtoConfirm;

	public String execute() {
		String result = SUCCESS ;

		BuyItemDAO dao = new BuyItemDAO();
		dtoConfirm =dao.getBuyItemConfirmInfo(Integer.parseInt(id));
		session.put("count", count);
		session.put("dtoConfirm", dtoConfirm);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(dtoConfirm.getItemPrice());
		session.put("total_price", intCount * intPrice);
		String payment;
		switch(pay){
		case "1":
			payment = "cash";
			session.put("pay", payment);
		default:
			payment = "credit";
			session.put("pay", payment);
		}
		//購入数と在庫数の比較
		BuyItemDTO dto = dao.getBuyItemInfo();
		if(intCount > dto.getItem_stock()){
			errorMessage = "在庫が残っていません";
			result = ERROR;
		}
		return result;
	}

	public  void setCount(int count) {
		this.count = count;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BuyItemDTO getDtoConfirm() {
		return dtoConfirm;
	}

	public void setDtoConfirm(BuyItemDTO dtoConfirm) {
		this.dtoConfirm = dtoConfirm;
	}
}
