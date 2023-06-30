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
 * Servlet implementation class LoginToContinueServlet
 */
@WebServlet("/LoginToContinueServlet")
public class LoginToContinueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginToContinueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		CustomerServiceRegisterLoginController ctrl = new CustomerServiceRegisterLoginController(new CustomerServiceRegisterLoginImpl(new CustomerDAOImpl()));
		
		Customer customer = ctrl.customerLogin(email, password);
		
		if(customer != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("customer", customer);
			response.sendRedirect("Basket.jsp");
		}else {
			
			response.sendRedirect("LoginToContinue.jsp");
		}
	}
}


