package com.ab.services;

import java.util.List;
import java.util.Map;

import com.ab.models.Book;
import com.ab.models.Order;

public interface OrderService {
	public Map<Book, Integer> placeOrder(int customerId, Order order);
	public int totalOrderCount();
	public List<Order> viewOrderHistory(int customerId);
	public int getMaxOrderId();
}
