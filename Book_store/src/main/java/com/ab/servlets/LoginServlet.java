package com.ab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.controllers.CustomerServiceRegisterLoginController;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerServiceRegisterLoginImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		CustomerServiceRegisterLoginController ctrl = new CustomerServiceRegisterLoginController(new CustomerServiceRegisterLoginImpl(new CustomerDAOImpl()));
		
		Customer customer = ctrl.customerLogin(email, password);
		
		if(customer != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("customer", customer);
			response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
		}else {
			
			response.sendRedirect("Login.jsp");
		}
	}

}
