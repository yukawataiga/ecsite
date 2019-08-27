package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{

	private String Id;
	public Map<String, Object> session;
	private UserInfoDTO userInfo = new UserInfoDTO();

	public String execute() throws SQLException{

		int id = Integer.parseInt(Id);
		UserDetailsDAO dao = new UserDetailsDAO();
		userInfo = dao.createInfo(id);

		session.put("userInfo", userInfo);
		session.put("Id",Id);
		return SUCCESS;
	}

	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDTO userInfo) {
		this.userInfo = userInfo;
	}
}
