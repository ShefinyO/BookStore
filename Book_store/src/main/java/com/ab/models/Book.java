package com.ab.models;

public class Book {
	
	private int bookId;
	private String bookName;
	private String author;
	private String weight;
	private String price;
	private String rating;
	private String category;
	private String description;
	private String isbn;
	private String image;
	
	//constructor
	public Book(int bookId, String bookName, String author, String weight, String price, String rating,String category, String description, String isbn, String image) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.weight = weight;
		this.price = price;
		this.rating = rating;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.setImage(image);
	}
	

	public Book(String bookName, String price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}


	//getters
	public int getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getIsbn() {
		return isbn;
	}

	//setters
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", weight=" + weight
				+ ", price=" + price + ", rating=" + rating +", category="+ category+ ", description=" + description + ", isbn=" + isbn ;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}	
	
	
}
