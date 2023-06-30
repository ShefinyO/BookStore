package com.ab.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.ab.models.Book;
import com.ab.utilities.DatabaseConnection;

public class BookDAOImpl implements BookDAO {
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	@Override
	public List<Book> viewAllBooks(){
		
		List<Book> allBooks = new ArrayList<>();
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("select * from book_info");
		
			this.rs = this.pst.executeQuery();
			
			while(this.rs.next()){
				allBooks.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getString("weight"),
				 rs.getString("price"), rs.getString("rating"),rs.getString("category"), rs.getString("description"), rs.getString("isbn"),rs.getString("image")));
			}
			
			return allBooks;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Book viewABook(int bookId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			this.pst = this.con.prepareStatement("select * from book_info where book_id = ?");
			
			this.pst.setInt(1, bookId);
			
			this.rs = this.pst.executeQuery();
			
			if(this.rs.next()) {
				return new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getString("weight"),
						 rs.getString("price"), rs.getString("rating"),rs.getString("category"), rs.getString("description"), rs.getString("isbn"),rs.getString("image"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<Book> searchForBooks(String input) {
		
		List<Book> allBooks = new ArrayList<>();
		this.con = DatabaseConnection.getConnection();
		Integer n = null;
		
		try {
			n = Integer.parseInt(input);
		}catch(NumberFormatException e){
			n = null;
			System.out.println(e);
		}
		
		try {
			
			if(n == null){
				
				this.pst = this.con.prepareStatement("select * from book_info where book_name like ?");
				
				this.pst.setString(1, "%"+input+"%");
				
				this.rs = this.pst.executeQuery();
				
				while(this.rs.next()){
					allBooks.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getString("weight"),
					 rs.getString("price"), rs.getString("rating"),rs.getString("category"), rs.getString("description"), rs.getString("isbn"),rs.getString("image")));
				}
				
				return allBooks;
				
			}else {
				
				this.pst = this.con.prepareStatement("select * from book_info where isbn like ?");
				
				this.pst.setString(1, "%"+n.toString()+"%");
				
				
				this.rs = this.pst.executeQuery();
				
				while(this.rs.next()){
					allBooks.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getString("weight"),
					 rs.getString("price"), rs.getString("rating"),rs.getString("category"), rs.getString("description"), rs.getString("isbn"),rs.getString("image")));
				}
				
				return allBooks;
				
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
		

}
