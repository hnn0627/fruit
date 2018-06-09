package com.fruit.vo;

public class BuyerVO {
	private String id;
	private String pass;
	private int money;
	private int appleCount;
	
	public BuyerVO() {}

	public BuyerVO(String id, String pass, int money, int appleCount) {
		super();
		this.id = id;
		this.pass = pass;
		this.money = money;
		this.appleCount = appleCount;
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
	
}
