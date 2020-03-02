package com.dizewei.pojo;
/** 
* @author 作者:dizewei
* @version 创建时间：2020年3月2日 下午1:42:55 
* 类功能说明 
*/

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	String id;
	private String name;
	private String sex;
	private String phone;
	private String emilS;
	private String birthday;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String sex, String phone, String emilS, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.emilS = emilS;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", emilS=" + emilS
				+ ", birthday=" + birthday + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmilS() {
		return emilS;
	}
	public void setEmilS(String emilS) {
		this.emilS = emilS;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
