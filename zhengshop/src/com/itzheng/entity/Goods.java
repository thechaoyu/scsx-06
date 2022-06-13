package com.itzheng.entity;

import java.util.Arrays;

public class Goods {

	private int id;
	private String goodcode;
	private String goodname;
	private String gooddetail;
	private String goodprice;
	private String gooddiscount;
	private String goodusercode;
	private User user;
	private String goodstate;
	private String goodimagecode;
	private String[] goodiamgecodearray = new String[5];
	private String gooddate;
	private String goodtypecode;
	
	private Images images;

	private GoodType goodType;

	public Goods() {
		super();
	}

	public Goods(int id, String goodcode, String goodname, String gooddetail, String goodprice, String gooddiscount,
			String goodusercode, User user, String goodstate, String goodimagecode, String gooddate,
			String goodtypecode, GoodType goodType) {
		super();
		this.id = id;
		this.goodcode = goodcode;
		this.goodname = goodname;
		this.gooddetail = gooddetail;
		this.goodprice = goodprice;
		this.gooddiscount = gooddiscount;
		this.goodusercode = goodusercode;
		this.user = user;
		this.goodstate = goodstate;
		this.goodimagecode = goodimagecode;
		this.gooddate = gooddate;
		this.goodtypecode = goodtypecode;
		this.goodType = goodType;
	}

	public String[] getGoodiamgecodearray() {
		return goodiamgecodearray;
	}

	public void setGoodiamgecodearray(String[] goodiamgecodearray) {
		this.goodiamgecodearray = goodiamgecodearray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodcode() {
		return goodcode;
	}

	public void setGoodcode(String goodcode) {
		this.goodcode = goodcode;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public String getGooddetail() {
		return gooddetail;
	}

	public void setGooddetail(String gooddetail) {
		this.gooddetail = gooddetail;
	}

	public String getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(String goodprice) {
		this.goodprice = goodprice;
	}

	public String getGooddiscount() {
		return gooddiscount;
	}

	public void setGooddiscount(String gooddiscount) {
		this.gooddiscount = gooddiscount;
	}

	public String getGoodusercode() {
		return goodusercode;
	}

	public void setGoodusercode(String goodusercode) {
		this.goodusercode = goodusercode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGoodstate() {
		return goodstate;
	}

	public void setGoodstate(String goodstate) {
		this.goodstate = goodstate;
	}

	public String getGoodimagecode() {
		return goodimagecode;
	}

	public void setGoodimagecode(String goodimagecode) {
		this.goodimagecode = goodimagecode;
	}

	public String getGooddate() {
		return gooddate;
	}

	public void setGooddate(String gooddate) {
		this.gooddate = gooddate;
	}

	public String getGoodtypecode() {
		return goodtypecode;
	}

	public void setGoodtypecode(String goodtypecode) {
		this.goodtypecode = goodtypecode;
	}

	public GoodType getGoodType() {
		return goodType;
	}

	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}
	
	

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodcode=" + goodcode + ", goodname=" + goodname + ", gooddetail=" + gooddetail
				+ ", goodprice=" + goodprice + ", gooddiscount=" + gooddiscount + ", goodusercode=" + goodusercode
				+ ", user=" + user + ", goodstate=" + goodstate + ", goodimagecode=" + goodimagecode
				+ ", goodiamgecodearray=" + Arrays.toString(goodiamgecodearray) + ", gooddate=" + gooddate
				+ ", goodtypecode=" + goodtypecode + ", goodType=" + goodType + "]";
	}

}
