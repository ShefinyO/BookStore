package com.ab.servlets;
import java.util.Map;



import java.io.IOException;
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
import java.util.HashMap;

/**
 * Servlet implementation class AddToBasketServlet
 */
@WebServlet("/AddToBasketServlet")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("bookId"));
		
		int bookId = id;
		Map<Book, Integer> basket = null;
		
		BookServiceController ctrl = new BookServiceController(new BookServiceImpl(new BookDAOImpl()));
		
		Book book = ctrl.viewABook(bookId);
		
		HttpSession session = request.getSession(true);
		boolean found = false;
		
		
		
		if(session.getAttribute("basket")== null) {
			basket = new HashMap<>();
			basket.put(book, 1);
			session.setAttribute("basket", basket);
		}else{
			 basket = (HashMap<Book, Integer>) session.getAttribute("basket");
			
			for(Map.Entry<Book, Integer> set: basket.entrySet()) {
				if(set.getKey().getBookId() == book.getBookId()){
					set.setValue(set.getValue()+1);
					found = true;
					break;
				}
			}
			
			if(found==false){
				basket = (HashMap<Book, Integer>)session.getAttribute("basket");
				basket.put(book, 1);
			}
			
			
			
		}
		
		
		
		response.sendRedirect("http://localhost:8080/Book_store/HomeServlet");
		
	
		
		
		
		
		
	}


}
