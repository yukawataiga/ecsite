package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String execute() throws SQLException {
		//購入の履歴をuser_buy_item_transactionに入れる
		BuyItemCompleteDAO inputdao = new BuyItemCompleteDAO();
		inputdao.buyItemInfo(
				String.valueOf(((BuyItemDTO)session.get("dtoConfirm")).getId()),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());

		//在庫を引き出したあと購入数を引く。またそれをitem_info_transactionにupdateする。
		BuyItemDAO dao = new BuyItemDAO();
		int buyCount = dao.getBuyItemInfo().getItem_stock();
		int inputCount = buyCount - (Integer.parseInt(session.get("count").toString()));
		inputdao.updateStock(inputCount, session.get("buyItem_name").toString());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
