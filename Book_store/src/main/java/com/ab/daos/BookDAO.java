package com.ab.daos;

import java.util.List;
import com.ab.models.Book;

public interface BookDAO {
	
	public List<Book> viewAllBooks();
	public Book viewABook(int bookId);
	public List<Book> searchForBooks(String input);
	

}
