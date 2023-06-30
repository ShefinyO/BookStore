package com.ab.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.models.Book;

/**
 * Servlet implementation class RemoveFromBasketServlet
 */
@WebServlet("/RemoveFromBasketServlet")
public class RemoveFromBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("bookId"));
		HttpSession session = request.getSession(true);
		Book keyToRemove = null;
		
		Map<Book, Integer> basket = (HashMap<Book, Integer>) session.getAttribute("basket");
		
		for(Map.Entry<Book, Integer> set: basket.entrySet()){
			if(set.getKey().getBookId() == id) {
				keyToRemove = set.getKey();
			}
		}
		
		basket.remove(keyToRemove);
		
		if(basket.isEmpty()){
			session.removeAttribute("basket");
		}
		
		response.sendRedirect("Basket.jsp");
		
		
	}

	

}
