package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private String errorMessage = null;

	public String execute() throws SQLException {
		String result = null;
		//項目が未記入の場合
		if(loginUserId.equals("") || loginPassword.equals("")) {
			setErrorMessage("パスワードもしくは未記入です。");
			result = ERROR;
		//項目が埋まってる場合
		}else{
			loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
			session.put("loginUser", loginDTO);

			//さっきの項目で管理したフラグで選択
			if(loginDTO.getLoginFlg()) {
				BuyItemDAO dao = new BuyItemDAO();
				ArrayList<BuyItemDTO> itemList = new ArrayList<>();
				itemList = dao.getBuyItemList();
				session.put("dto", itemList);
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
				session.put("login_user_id", loginDTO.getLoginId());
				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
				result = SUCCESS;
			//フラグが無かった場合
			}else{
				setErrorMessage("IDもしくはパスワードが間違ってます");
				result = ERROR;
			}
			//もしAdminの値が1に変わってたらsession.putする
			if(loginDTO.getAdminFlg().equals("1")) {
				session.put("admin", "1");
				result = "admin";
			}
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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
}

