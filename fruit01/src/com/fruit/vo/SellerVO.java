package com.fruit.vo;

public class SellerVO {
	private String id;
	private String pass;
	private int money;
	private int appleCount;
	private int applePrice;
	
	public SellerVO() { }
	
	public SellerVO(String id, String pass, int money, int appleCount, int applePrice) {
		this.id = id;
		this.pass = pass;
		this.money = money;
		this.appleCount = appleCount;
		this.applePrice = applePrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAppleCount() {
		return appleCount;
	}
	public void setAppleCount(int appleCount) {
		this.appleCount = appleCount;
	}
	public int getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(int applePrice) {
		this.applePrice = applePrice;
	}
	
}
