package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.internousdev.ecsite.util.CreateHash;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;
	private String str = "";

	public String execute() throws SQLException{

		String result = SUCCESS;
		//未記入の判別
		if(!(loginUserId.equals(""))
			&& !(loginPassword.equals(""))
			&& !(userName.equals(""))) {
			int charSize = loginPassword.length();
			for (int i = 0; i < charSize ; i++){
				str = str + '*';
			}
			session.put("loginUserId", loginUserId);
			session.put("userName",userName);
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR ;
		}

		//存在するユーザーの判別
		UserCreateConfirmDAO dao = new UserCreateConfirmDAO();
		ArrayList<String> idList = dao.getID();
		for(String list : idList) {
			if(loginUserId.equals(list)){
				setErrorMessage(list+"はすでに存在してるIDです。");
				result = ERROR;
			}
		}

		//1回ハッシュされたパスワードをpendingとして入れる。
		CreateHash hash = new CreateHash();
		String hashPass = hash.getSafetyPassword(loginPassword, userName);
		dao.pendingUser(hashPass);
		session.put("HashPass",hashPass);
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

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
