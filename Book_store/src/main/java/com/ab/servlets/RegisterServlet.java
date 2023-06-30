package com.ab.servlets;
import com.ab.controllers.*;
import com.ab.daos.*;
import com.ab.services.*;
import com.ab.models.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Map<Book, Integer> basket = null;
		
		CustomerServiceRegisterLoginController ctrl = new CustomerServiceRegisterLoginController(new CustomerServiceRegisterLoginImpl(new CustomerDAOImpl()));
		
		Customer customer = new Customer(firstName, lastName, email, password);
		
		Customer newCustomer = ctrl.customerRegister(customer);
		
		HttpSession session = request.getSession(true);
		basket = (HashMap<Book, Integer>) session.getAttribute("basket");
		
		if(newCustomer != null){
			if(basket == null) {
				response.sendRedirect("Login.jsp");
			}else {
				response.sendRedirect("LoginToContinue.jsp");
			}
		}	
	}

}
