package com.uxpsystems.assignement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	public User() {

	}

	public User(String userName, String password, String status) {
		this.userName = userName;
		this.password = password;
		this.status = status;
	}

	public long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", userName=" + userName + ", password=" + password + ", status=" + status + "]";
	}
}
