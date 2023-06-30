package com.ab.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.ab.models.Book;
import com.ab.models.Order;
import com.ab.utilities.DatabaseConnection;

public class OrderDAOImpl implements OrderDAO{
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	

	
	@Override
	public Map<Book, Integer> placeOrder(int customerId, Order order) {
		
		this.con = DatabaseConnection.getConnection();
		Date sqlDate = java.sql.Date.valueOf(order.getOrderDate());
		Map<Book, Integer> orderItems = order.getBooks();
		
		if(orderItems == null) {
			return null;
		}
		
		System.out.println(orderItems);
		
		try {
			
			this.pst = this.con.prepareStatement("insert into order_info(order_id, customer_id, order_date, total_price) values(?,?,?,?)");
			
			this.pst.setInt(1, order.getOrderId());
			this.pst.setInt(2, customerId);
			this.pst.setDate(3, sqlDate);
			this.pst.setString(4, order.getTotalPrice());
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("insert into orders_books(order_id, book_id, quantity) values(?,?,?)");
					
					
					for(Map.Entry<Book, Integer> set: orderItems.entrySet()) {
						
						this.pst.setInt(1, order.getOrderId());
						this.pst.setInt(2, set.getKey().getBookId());
						this.pst.setInt(3, set.getValue());
						
						int j = this.pst.executeUpdate();
						
						
					}
					
					return orderItems;
					
				
				}catch(SQLException e){
					
					System.out.println(e);
					e.printStackTrace();
				}
				
			}
			
			
		} catch (SQLException e) {
			
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
		
	}



	@Override
	public int totalOrderCount() {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			this.pst = this.con.prepareStatement("select count(order_id) as totalOrders from order_info");
			this.rs = this.pst.executeQuery();
			
			if(this.rs.next()) {
				return rs.getInt("totalOrders");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}



	@Override
	public List<Order> viewOrderHistory(int CustomerId) {
		this.con = DatabaseConnection.getConnection();
		 
		
		//Map<Integer, Map<Book, Integer>> orderHistory = new HashMap<>();
		List<Order> ordersList = new ArrayList<>();
		Map<Book, Integer> items = null;
		
		
		try {
			this.pst = this.con.prepareStatement("select o.order_id, b.book_name, b.price, ob.quantity,o.order_date, o.total_price "
					+ "from order_info o "
					+ "inner join orders_books ob on o.order_id = ob.order_id "
					+ "inner join book_info b on b.book_id = ob.book_id "
					+ "where o.customer_id = ? "
					+ "order by o.order_date desc");
			
			this.pst.setInt(1, CustomerId);
			
			this.rs = this.pst.executeQuery();
			
			while(this.rs.next()) {
				boolean found = false;
				
				Book cb = new Book(rs.getString("book_name"), rs.getString("price"));
				
				/*if(orderHistory.containsKey(rs.getInt("order_id"))) {
					orderHistory.get(rs.getInt("order_id")).put(cb, rs.getInt("quantity"));
				}else {
					Map<Book, Integer> order = new HashMap<>();
					order.put(cb, rs.getInt("quantity"));
					orderHistory.put(rs.getInt("order_id"),order);
				}	*/
				
				if(ordersList.size() == 0){
					items = new HashMap<>();
					items.put(cb, rs.getInt("quantity"));
					LocalDate date = rs.getDate("order_date").toLocalDate();
					ordersList.add(new Order(rs.getInt("order_id"),items, date, rs.getString("total_price")));
				}else {
					for(Order curOrder: ordersList){
						if(curOrder.getOrderId() == rs.getInt("order_id")) {
							curOrder.addBook(cb, rs.getInt("quantity"));
							found = true;
							break;
						}
					}
					if(found == true) {
						continue;
					}
					items = new HashMap<>();
					items.put(cb, rs.getInt("quantity"));
					LocalDate date = rs.getDate("order_date").toLocalDate();
					ordersList.add(new Order(rs.getInt("order_id"),items, date, rs.getString("total_price")));
					
					
				}
				
			
				
			}
			
			return ordersList;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public int getMaxOrderId() {
		this.con = DatabaseConnection.getConnection();
		
		try {
			this.pst = this.con.prepareStatement("select max(order_id) as max_num from order_info");
			
			this.rs = this.pst.executeQuery();
			
			if(this.rs.next()) {
				
				int max = rs.getInt("max_num");
				return max;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
