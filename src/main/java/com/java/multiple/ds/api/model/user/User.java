package com.java.multiple.ds.api.model.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name="USER_TB")
public class User {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="userName")
	private String userName;
	
	public User(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
