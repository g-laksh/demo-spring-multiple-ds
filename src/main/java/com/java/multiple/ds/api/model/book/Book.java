package com.java.multiple.ds.api.model.book;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="BOOK_TB")
public class Book {
	@Id
	@Column(name="id")

	private int id;
	@Column(name="name")
	private String name; 
	public Book(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
