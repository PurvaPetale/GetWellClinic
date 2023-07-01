package com.entity;

public class User {
	private int id;
	private String fullname;
	private String email;
	private String password;
	private String address;
	private String gender;
	private String age;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fullname, String email, String password, String address, String gender, String age) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}
