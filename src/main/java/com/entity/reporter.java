package com.entity;

public class reporter {
	
	private int id;
	private String doctname;
	private String leavesd;
	private String leaveed;
	private String status;
	private String email;
	private String password;
	

	
	public reporter() {
		super();
		// TODO Auto-generated constructor stub
	}



	public reporter(int id, String doctname, String leavesd, String leaveed, String status, String email,
			String password) {
		super();
		this.id = id;
		this.doctname = doctname;
		this.leavesd = leavesd;
		this.leaveed = leaveed;
		this.status = status;
		this.email = email;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDoctname() {
		return doctname;
	}



	public void setDoctname(String doctname) {
		this.doctname = doctname;
	}



	public String getLeavesd() {
		return leavesd;
	}



	public void setLeavesd(String leavesd) {
		this.leavesd = leavesd;
	}



	public String getLeaveed() {
		return leaveed;
	}



	public void setLeaveed(String leaveed) {
		this.leaveed = leaveed;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	
}	