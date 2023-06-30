package com.ab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.controllers.BookServiceController;
import com.ab.daos.BookDAOImpl;
import com.ab.models.Book;
import com.ab.services.BookService;
import com.ab.services.BookServiceImpl;

/**
 * Servlet implementation class BookPageServlet
 */
@WebServlet("/BookPageServlet")
public class BookPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("bookId"));
		
		int bookId = id;
		
		BookServiceController ctrl = new BookServiceController(new BookServiceImpl(new BookDAOImpl()));
		
		Book book = ctrl.viewABook(bookId);
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("BookPage.jsp").forward(request, response);
		
		
		
	}

	
}
