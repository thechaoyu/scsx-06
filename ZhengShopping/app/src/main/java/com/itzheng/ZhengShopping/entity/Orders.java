package com.itzheng.ZhengShopping.entity;

public class Orders {

	private int id;
	private String ordercode;
	private String usercode;
	private String state;
	private String date;
	private String price;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int id, String ordercode, String usercode, String state, String date, String price) {
		super();
		this.id = id;
		this.ordercode = ordercode;
		this.usercode = usercode;
		this.state = state;
		this.date = date;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", ordercode=" + ordercode + ", usercode=" + usercode + ", state=" + state
				+ ", date=" + date + ", price=" + price + "]";
	}

}
