package com.ab.controllers;

import java.util.List;

import com.ab.models.Book;
import com.ab.services.BookService;

public class BookServiceController {
	
	
	private BookService bookService;
	
	public BookServiceController(BookService bookService) {
		
		this.bookService = bookService;
		
	}
	
	public List<Book> viewAllBooks() {
		return bookService.viewAllBooks();
	}

	public Book viewABook(int bookId) {
		return bookService.viewABook(bookId);
	}
	
	public List<Book> searchForBooks(String input){
		return bookService.searchForBooks(input);
		
	}

}
