package com.itzheng.entity;

public class User {

	private int id;
	private String usercode;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String usertype;
	private String state;
	private String image;
	private String date;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String usercode, String username, String password, String name, String email, String phone,
			String usertype, String state, String image, String date) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.usertype = usertype;
		this.state = state;
		this.image = image;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", username=" + username + ", password=" + password
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", usertype=" + usertype + ", state="
				+ state + ", image=" + image + ", date=" + date + "]";
	}

}
