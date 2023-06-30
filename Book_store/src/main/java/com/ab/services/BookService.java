package com.ab.services;

import java.util.List;

import com.ab.models.Book;

public interface BookService {
	
	public List<Book> viewAllBooks();
	public Book viewABook(int bookId);
	public List<Book> searchForBooks(String input);

}
