package com.ab.services;

import java.util.List;

import com.ab.daos.BookDAO;
import com.ab.models.Book;

public class BookServiceImpl implements BookService{
	
	private BookDAO bookDao;
	
	public BookServiceImpl(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> viewAllBooks() {
		return bookDao.viewAllBooks();
	}

	@Override
	public Book viewABook(int bookId) {
		return bookDao.viewABook(bookId);
	}

	@Override
	public List<Book> searchForBooks(String input) {
		return bookDao.searchForBooks(input);
	}
	
}
