package com.internousdev.ecsite.dto;

public class UserInfoDTO {
	private String admin_flg, login_id, login_pass, user_name, insert_date;
	private int id;

	public String getAdmin_flg() {
		return admin_flg;
	}
	public void setAdmin_flg(String admin_flg) {
		this.admin_flg = admin_flg;
	}

	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
}
