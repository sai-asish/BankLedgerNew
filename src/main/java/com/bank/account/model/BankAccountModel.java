package com.bank.account.model;

public class BankAccountModel {
	
	private String loginName;
	private String name;
	private Integer number;
	private String currency;
	
	
    public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "BankAccountModel [loginName=" + loginName + ", name=" + name + ", number=" + number + ", currency="
				+ currency + "]";
	}

}
