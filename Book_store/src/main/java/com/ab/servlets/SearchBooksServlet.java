package com.ab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.controllers.BookServiceController;
import com.ab.daos.BookDAOImpl;
import com.ab.models.Book;
import com.ab.services.BookServiceImpl;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet("/SearchBooksServlet")
public class SearchBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String input = request.getParameter("searchBar");
		String em = "";
		
		
		if(input.equals(em)) {
			response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
			return;
		}
		
		System.out.println(input.equals(em));
		
		BookServiceController ctrl2 = new BookServiceController(new BookServiceImpl(new BookDAOImpl()));
		
		
		List<Book> result = ctrl2.searchForBooks(input);
		
		request.setAttribute("allBooks", result);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		
		
		
		
		
	}

}
