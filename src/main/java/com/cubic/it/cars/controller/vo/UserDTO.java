package com.cubic.it.cars.controller.vo;

import java.sql.Timestamp;

public class UserDTO {
	private int uid;
	private String userid;
	private String password;
	private String email;
	private String name;
	private String mobile;
	private String image;
	private String salutation;
	private Timestamp createDate;
	private String role;
	
	public UserDTO() {}
	public UserDTO(String userid, String password, String email, String name, String mobile, String image,
			String salutation) {
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.image = image;
		this.salutation = salutation;
	}
	
	

	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "UserEntity [uid=" + uid + ", userid=" + userid + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", mobile=" + mobile + ", image=" + image + ", salutation=" + salutation
				+ ", createDate=" + createDate + ", role=" + role + "]";
	}
	
	

}
