package com.masai.Dto;

public class StudentImpl implements Student {
	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	private String sEmail;
	
	private String firsttName;
	private String lastName;
	private String address;
	
	private String sPassword;
	private int mobile_no;
	private  Boolean is_deleted;
	
	
	
	public String getFirsttName(){
		return firsttName;
	}


	public void setFirsttName(String firsttName){
		this.firsttName = firsttName;
	}


	public String getLastName(){
		return lastName;
	}


	public void setLastName(String lastName){
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address){
		this.address = address;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}


	public String getsPassword() {
		return sPassword;
	}


	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}


	public int getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}


	public StudentImpl(String firsttName, String lastName, String address, String sEmail, String sPassword,
			int mobile_no, Boolean is_deleted) {
		super();
		this.firsttName = firsttName;
		this.lastName = lastName;
		this.address = address;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
		this.mobile_no = mobile_no;
		this.is_deleted = is_deleted;
	}


	

	public StudentImpl(String sEmail, String sPassword) {
		super();
		this.sEmail = sEmail;
		this.sPassword = sPassword;
	}


	public Boolean getIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


	
	

}