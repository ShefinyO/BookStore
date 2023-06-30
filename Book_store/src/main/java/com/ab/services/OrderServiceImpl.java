package com.ab.services;

import java.util.List;
import java.util.Map;

import com.ab.daos.OrderDAO;
import com.ab.models.Book;
import com.ab.models.Order;

public class OrderServiceImpl implements OrderService{
	
	private OrderDAO orderDao;

	public OrderServiceImpl(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Map<Book, Integer> placeOrder(int customerId, Order order) {
		
		return orderDao.placeOrder(customerId, order);
		
	}

	@Override
	public int totalOrderCount() {
		return orderDao.totalOrderCount();
	}

	@Override
	public List<Order> viewOrderHistory(int customerId) {
		return orderDao.viewOrderHistory(customerId);
	}

	@Override
	public int getMaxOrderId() {
		
		return orderDao.getMaxOrderId();
	}
	
	
	
}
