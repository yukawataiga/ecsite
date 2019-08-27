package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.internousdev.ecsite.util.CreateHash;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserCreateCompleteDAO dao = new UserCreateCompleteDAO();
	CreateHash hash = new CreateHash();

	public String execute() throws SQLException {
		String hashPass = session.get("HashPass").toString();
		dao.deletePendingUser(hashPass);

		//もう一度ハッシュをまわす。
		hashPass = hash.getSafetyPassword(hashPass, session.get("userName").toString());
		dao.createUser(session.get("loginUserId").toString(),hashPass,session.get("userName").toString());

		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
