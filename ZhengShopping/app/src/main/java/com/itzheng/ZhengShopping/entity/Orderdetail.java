package com.itzheng.ZhengShopping.entity;

public class Orderdetail {

	private int id;
	private String orderdetailcode;
	private String usersellercode;
	private String userbuyercode;
	private String ordercode;
	private String goodcode;
	private String goodnumber;
	private String state;
	private String date;
	private String price;

	public Orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orderdetail(int id, String orderdetailcode, String usersellercode, String userbuyercode, String ordercode,
			String goodcode, String goodnumber, String state, String date, String price) {
		super();
		this.id = id;
		this.orderdetailcode = orderdetailcode;
		this.usersellercode = usersellercode;
		this.userbuyercode = userbuyercode;
		this.ordercode = ordercode;
		this.goodcode = goodcode;
		this.goodnumber = goodnumber;
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

	public String getOrderdetailcode() {
		return orderdetailcode;
	}

	public void setOrderdetailcode(String orderdetailcode) {
		this.orderdetailcode = orderdetailcode;
	}

	public String getUsersellercode() {
		return usersellercode;
	}

	public void setUsersellercode(String usersellercode) {
		this.usersellercode = usersellercode;
	}

	public String getUserbuyercode() {
		return userbuyercode;
	}

	public void setUserbuyercode(String userbuyercode) {
		this.userbuyercode = userbuyercode;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getGoodcode() {
		return goodcode;
	}

	public void setGoodcode(String goodcode) {
		this.goodcode = goodcode;
	}

	public String getGoodnumber() {
		return goodnumber;
	}

	public void setGoodnumber(String goodnumber) {
		this.goodnumber = goodnumber;
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
		return "Orderdetail [id=" + id + ", orderdetailcode=" + orderdetailcode + ", usersellercode=" + usersellercode
				+ ", userbuyercode=" + userbuyercode + ", ordercode=" + ordercode + ", goodcode=" + goodcode
				+ ", goodnumber=" + goodnumber + ", state=" + state + ", date=" + date + ", price=" + price + "]";
	}

}
