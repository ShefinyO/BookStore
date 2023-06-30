package com.ab.models;
import java.time.LocalDate;
import java.util.Map;

public class Order {
	
	private int OrderId;
	private Customer customer;
	private Map<Book, Integer> books;
	private LocalDate orderDate;
	private String totalPrice;
	
	public Order(int orderId, Customer customer, Map<Book, Integer> books, LocalDate orderDate, String totalPrice) {
		
		this.OrderId = orderId;
		this.customer = customer;
		this.books = books;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	
	public Order(int orderId, Map<Book, Integer> books, LocalDate orderDate, String totalPrice) {
		
		this.OrderId = orderId;
		this.books = books;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}

	
	public int getOrderId() {
		return OrderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Map<Book, Integer> getBooks() {
		return books;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setOrderId(int orderId) {
		this.OrderId = orderId;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setBooks(Map<Book, Integer> books) {
		this.books = books;
	}
	
	public void addBook(Book book, int quantity) {
		this.books.put(book, quantity);
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderId=" + OrderId + ", customer=" + customer + ", books=" + books + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice;
	}
	
}
