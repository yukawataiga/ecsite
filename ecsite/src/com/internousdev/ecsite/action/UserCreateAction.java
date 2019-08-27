package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware{

	private String flg ="";
	private Map<String, Object> session;

	public String execute() throws SQLException{
		if(flg.equals("1")){
			deletePendingUser();
		}
		return SUCCESS ;
	}

	private void deletePendingUser() throws SQLException{
		UserCreateConfirmDAO dao = new UserCreateConfirmDAO();
		dao.deletePendingUser(session.get("HashPass").toString());
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}
}
