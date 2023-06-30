package com.ab.servlets;
import com.ab.controllers.OrderServiceController;
import com.ab.daos.OrderDAOImpl;
import com.ab.services.OrderServiceImpl;
import com.ab.models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String total = request.getParameter("total");
		System.out.println(total);
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("customer");
		
		if(customer == null){
			response.sendRedirect("LoginToContinue.jsp");
			
		}else {
			
			Map<Book, Integer> basket = (HashMap<Book, Integer>)session.getAttribute("basket");
			
			if(basket == null) {
				response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
				
			}
			
			int customerId = customer.getCustomerId();
			LocalDate date = LocalDate.now();
			
			OrderServiceController ctrl = new OrderServiceController(new OrderServiceImpl(new OrderDAOImpl()));
			
			int max = ctrl.getMaxOrderId();
			
			Order newOrder = new Order(max+1, basket, date, total.toString());
			
			Map<Book, Integer> result = ctrl.placeOrder(customerId, newOrder);
			
			if(result != null){
				session.removeAttribute("basket");
				session.setAttribute("order", newOrder);
				response.sendRedirect("OrderSuccessful.jsp");
				return;
			}
			else{
				response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
				
			}
			
			
			
		}
		
	}

	

}
