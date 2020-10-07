package org.System.entity;

public class User {
	public int id;
	public String username;
	public String password;
	public String usertype;
	public String gender;
	public String authorization;
	
	public User(String username,String passwrod,String usertype,String gender,String authorization) {
		this.username=username;
		this.password=password;
		this.usertype=usertype;
		this.gender=gender;
		this.authorization=authorization;
	}
	
	public User(int id,String username,String passwrod,String usertype,String gender,String authorization) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.usertype=usertype;
		this.gender=gender;
		this.authorization=authorization;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gener) {
		this.gender = gener;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	
}
