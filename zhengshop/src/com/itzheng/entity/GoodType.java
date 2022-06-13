package com.itzheng.entity;

public class GoodType {

	private int id;
	private String goodtypecode;
	private String typename;

	public GoodType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodType(int id, String goodtypecode, String typename) {
		super();
		this.id = id;
		this.goodtypecode = goodtypecode;
		this.typename = typename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodtypecode() {
		return goodtypecode;
	}

	public void setGoodtypecode(String goodtypecode) {
		this.goodtypecode = goodtypecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "GoodType [id=" + id + ", goodtypecode=" + goodtypecode + ", typename=" + typename + ", getId()="
				+ getId() + ", getGoodtypecode()=" + getGoodtypecode() + ", getTypename()=" + getTypename()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
