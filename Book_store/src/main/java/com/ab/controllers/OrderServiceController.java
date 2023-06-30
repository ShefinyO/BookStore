package com.ab.controllers;

import java.util.List;
import java.util.Map;

import com.ab.models.Book;
import com.ab.models.Order;
import com.ab.services.OrderService;

public class OrderServiceController {
	
	
	private OrderService orderService;

	public OrderServiceController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public Map<Book, Integer> placeOrder(int customerId, Order order) {
			
		return orderService.placeOrder(customerId, order);
			
	}
	
	public int totalOrderCount(){
		return orderService.totalOrderCount();
	}
	
	public List<Order> viewOrderHistory(int customerId){
		
		return orderService.viewOrderHistory(customerId);
		
	}
	
	public int getMaxOrderId(){
		return orderService.getMaxOrderId();
	}

}
