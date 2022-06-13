package com.itzheng.entity;

public class Car {

	private int id;
	private String carcode;
	private String usercode;
	private String goodcode;
	private String goodnumber;
	private String state;
	private String date;
	private Goods goods;
	

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int id, String carcode, String usercode, String goodcode, String goodnumber, String state, String date) {
		super();
		this.id = id;
		this.carcode = carcode;
		this.usercode = usercode;
		this.goodcode = goodcode;
		this.goodnumber = goodnumber;
		this.state = state;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarcode() {
		return carcode;
	}

	public void setCarcode(String carcode) {
		this.carcode = carcode;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
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
	
	

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carcode=" + carcode + ", usercode=" + usercode + ", goodcode=" + goodcode
				+ ", goodnumber=" + goodnumber + ", state=" + state + ", date=" + date + "]";
	}
	
	

}
