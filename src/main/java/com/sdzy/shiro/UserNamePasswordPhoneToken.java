package com.sdzy.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserNamePasswordPhoneToken extends UsernamePasswordToken {
	private String previousPassword;
	private String storeCode;
	private static final long serialVersionUID = 1L;

	public UserNamePasswordPhoneToken(String username, String password, String previousPassword, String storeCode) {
		super(username, password);
		this.previousPassword = previousPassword;
		this.storeCode = storeCode;
	}
	public UserNamePasswordPhoneToken(String phone) {
		super(null, phone);
	}


	public String getPreviousPassword() {
		return this.previousPassword;
	}

	public void setPreviousPassword(String previousPassword) {
		this.previousPassword = previousPassword;
	}

	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

}
