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
import com.ab.models.Customer;
import com.ab.services.BookServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		BookServiceController ctrl = new BookServiceController(new BookServiceImpl(new BookDAOImpl()));
		
		List<Book> allBooks = ctrl.viewAllBooks();
		
		request.setAttribute("allBooks", allBooks);
		
		HttpSession session = request.getSession(true);
		
		Customer c = (Customer) session.getAttribute("customer");
		
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		
		
		
		
		
	}

	

}
