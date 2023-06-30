import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;
import com.ab.controllers.BookServiceController;
import com.ab.controllers.CustomerEditDetailsServiceController;
import com.ab.controllers.CustomerServiceRegisterLoginController;
import com.ab.daos.BookDAOImpl;
import com.ab.daos.CustomerDAOImpl;
import com.ab.models.Book;
import com.ab.models.Customer;
import com.ab.services.BookServiceImpl;
import com.ab.services.CustomerEditDetailsServiceImpl;
import com.ab.services.CustomerServiceRegisterLoginImpl;
import com.ab.controllers.OrderServiceController;
import com.ab.services.OrderServiceImpl;
import com.ab.daos.*;
import com.ab.models.Order;


public class Main {

	public static void main(String[] args) {
		
		OrderServiceController ctrl = new OrderServiceController(new OrderServiceImpl(new OrderDAOImpl()));
		BookServiceController ctrl2 = new BookServiceController(new BookServiceImpl(new BookDAOImpl()));
		CustomerServiceRegisterLoginController ctrl3 = new CustomerServiceRegisterLoginController(new CustomerServiceRegisterLoginImpl(new CustomerDAOImpl()));
		CustomerEditDetailsServiceController ctrl4 = new CustomerEditDetailsServiceController(new CustomerEditDetailsServiceImpl(new CustomerDAOImpl())); 
		/*Map<Book, Integer> order= new HashMap<>();
		
		Book b1 = new Book(1, "Rich Dad Poor Dad", "Robert T. Kiyosaki", "400","Finance", "4.99", "4.7", "Rich Dad Poor Dad is Robert's story of growing up with two dads - his real father and the father of his best friend, his rich dad - and the ways in which both men shaped his thoughts about money and investing. The book explodes the myth that you need to earn a high income to be rich and explains the difference between working for money and having your money work for you. In the 20th Anniversary Edition of this classic, Robert offers an update on what we've seen over the past 20 years related to money, investing, and the global economy. Sidebars throughout the book will take readers from 1997 to today as Robert assesses how the principles taught by his rich dad have stood the test of time. In many ways, the messages of Rich Dad Poor Dad, messages that were criticized and challenged two decades ago, are more meaningful, relevant and important today than they were 20 years ago. As always, readers can expect that Robert will be candid, insightful... and continue to rock more than a few boats in his retrospective. Will there be a few surprises? Count on it.", 1612680194);
		Customer c1 = new Customer(3, "Zamhan", "Basheer", "shammu10@gmail.com", "Kingdom1234!");
		
		order.put(b1, 2);
		
		LocalDate date = LocalDate.now();
		
		Order or1 = new Order(c1, order,date ,"10.00");*/
		
		
		//List<Book> allBooks = ctrl2.searchForBooks("9781");
		
		
		//List<Order> res = ctrl.viewOrderHistory();
		//Map<Book, Integer> orderedItems = ctrl.placeOrder(c1.getCustomerId(), or1);
		
		//Customer c = ctrl3.viewCustomerDetails(6);
		
		Customer c = ctrl4.editPassword("yamakingi", 6);
		
		
		System.out.println(c);
		
		
		
	}

}
