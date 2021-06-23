package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="sapnabook")
public class Book {
	private String title;
	@Id
	@Column(name = "bookid")
	private Integer bookId;
	private String author;
	
	private String description;
	@Column(name = "imagePath")
	private String imagePath;
	
	private String category;
	private Double price;
	
	
	
	


}
