package com.ab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.controllers.CustomerEditDetailsServiceController;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Customer;
import com.ab.services.CustomerEditDetailsServiceImpl;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileNo = request.getParameter("mobileNo");
		
		CustomerEditDetailsServiceController ctrl = new CustomerEditDetailsServiceController(new CustomerEditDetailsServiceImpl(new CustomerDAOImpl()));
		
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer) session.getAttribute("customer");
		
		if(!firstName.equals("")){
			customer = ctrl.editFirstName(firstName, customer.getCustomerId());
			if(customer == null) {
				response.sendRedirect("Profile.jsp");
				return;
			}
		}
		
		if(!lastName.equals("")){
			customer = ctrl.editLastName(lastName, customer.getCustomerId());
			if(customer == null) {
				response.sendRedirect("Profile.jsp");
				return;
			}
		}
		
		if(!email.equals("")){
			customer = ctrl.editEmail(email, customer.getCustomerId());
			if(customer == null) {
				response.sendRedirect("Profile.jsp");
				return;
			}
		}
		
		if(!password.equals("")){
			customer = ctrl.editPassword(password, customer.getCustomerId());
			if(customer == null) {
				response.sendRedirect("Profile.jsp");
				return;
			}
		}
		
		if(!mobileNo.equals("")){
			customer = ctrl.editMobileNo(mobileNo, customer.getCustomerId());
			if(customer == null) {
				response.sendRedirect("Profile.jsp");
				return;
			}
		}
		
		session.setAttribute("customer", customer);
		response.sendRedirect("Profile.jsp");
		return;
		
		
	}

}
