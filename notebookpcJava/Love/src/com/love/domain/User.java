package com.love.domain;

public class User {
	private String userid;
	private String username;
	private String password;
	private String sex;
	private String age;
	private String createtime;
	private String undealMsg;
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", age=" + age + ", createtime=" + createtime + ", undealMsg=" + undealMsg + "]";
	}
	public User(String userid, String username, String password, String sex, String age, String createtime,
			String undealMsg) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.createtime = createtime;
		this.undealMsg = undealMsg;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUndealMsg() {
		return undealMsg;
	}
	public void setUndealMsg(String undealMsg) {
		this.undealMsg = undealMsg;
	}
	
	
}
