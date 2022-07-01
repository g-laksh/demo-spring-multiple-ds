package com.java.multiple.ds.api.model.book;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK_TB")
public class Book {
	public Book(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	@Id
	private int id;
	private String name;
}
