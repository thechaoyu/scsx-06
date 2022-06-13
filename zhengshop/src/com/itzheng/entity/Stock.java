package com.itzheng.entity;

public class Stock {

	private int id;
	private String stockcode;
	private String goodcode;
	private String goodnumber;
	private String usercode;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(int id, String stockcode, String goodcode, String goodnumber, String usercode) {
		super();
		this.id = id;
		this.stockcode = stockcode;
		this.goodcode = goodcode;
		this.goodnumber = goodnumber;
		this.usercode = usercode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
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

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockcode=" + stockcode + ", goodcode=" + goodcode + ", goodnumber=" + goodnumber
				+ ", usercode=" + usercode + "]";
	}

}
