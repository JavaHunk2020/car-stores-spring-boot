package com.cubic.it.cars.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_tbl")
public class UserEntity {
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
	
	public UserEntity() {}
	public UserEntity(String userid, String password, String email, String name, String mobile, String image,
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Column(length=50)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(length=30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length=200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=100)
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

@Column(length=500)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	@Column(length=4)
	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(length=20)
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
