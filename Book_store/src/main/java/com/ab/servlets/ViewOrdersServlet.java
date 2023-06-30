package com.ab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.controllers.OrderServiceController;
import com.ab.daos.OrderDAOImpl;
import com.ab.models.Customer;
import com.ab.models.Order;
import com.ab.services.OrderServiceImpl;

/**
 * Servlet implementation class ViewOrdersServlet
 */
@WebServlet("/ViewOrdersServlet")
public class ViewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Customer c = (Customer) session.getAttribute("customer");
		
		
		if(c == null) {
			response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
			return;
		}
		
		
		OrderServiceController ctrl = new OrderServiceController(new OrderServiceImpl(new OrderDAOImpl()));
		
		List<Order> ordersList= ctrl.viewOrderHistory(c.getCustomerId());
		
		if(ordersList != null) {
			
			request.setAttribute("ordersList", ordersList);
			
			request.getRequestDispatcher("OrderHistory.jsp").forward(request, response);
			
		}else {
			
			response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
		}
		
		
		
	}

	

}
