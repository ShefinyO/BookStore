package com.ab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ab.models.Customer;
import com.ab.utilities.DatabaseConnection;

public class CustomerDAOImpl implements CustomerDAO{
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;


	@Override
	public Customer customerRegister(Customer customer){
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			this.pst = this.con.prepareStatement("INSERT into customer_info(first_name, last_name, email, password) values(?,?,?,?)");
			
			this.pst.setString(1, customer.getFirstName());
			this.pst.setString(2, customer.getLastName());
			this.pst.setString(3, customer.getEmail());
			this.pst.setString(4, customer.getPassword());
			
			int i = this.pst.executeUpdate();
			
			if(i > 0){
				return customer;
			}
		}
		catch(SQLException e){
			System.out.println(e);
			return null;
		}
		return null;
		
	}
	


	@Override
	public Customer customerLogin(String emailId, String password){
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			this.pst = this.con.prepareStatement("select * from customer_info where email = ? && password = ?");
			
			this.pst.setString(1, emailId);
			this.pst.setString(2, password);
			
			this.rs = this.pst.executeQuery();
			
			if(this.rs.next()){
				return new Customer(rs.getInt("customer_id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
			}
			
		}
		catch(SQLException e){
			System.out.println(e);
			
		}
		
		return null;
	
		
	}



	@Override
	public Customer viewCustomerDetails(int customerId) {
		
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
			
			this.pst.setInt(1, customerId);
			
			this.rs = this.pst.executeQuery();
			
			if(this.rs.next()){
				return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public Customer editFirstName(String firstName, int customerId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("update customer_info set first_name = ? where customer_id = ?");
			
			this.pst.setString(1, firstName);
			this.pst.setInt(2, customerId);
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
					
					this.pst.setInt(1, customerId);
					
					this.rs = this.pst.executeQuery();
					
					if(this.rs.next()){
						return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
							
					}
				}catch (SQLException e) {
					System.out.println("error in return");
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public Customer editLastName(String lastName, int customerId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("update customer_info set last_name = ? where customer_id = ?");
			
			this.pst.setString(1, lastName);
			this.pst.setInt(2, customerId);
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
					
					this.pst.setInt(1, customerId);
					
					this.rs = this.pst.executeQuery();
					
					if(this.rs.next()){
						return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
							
					}
				}catch (SQLException e) {
					System.out.println("error in return");
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public Customer editEmail(String email, int customerId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("update customer_info set email = ? where customer_id = ?");
			
			this.pst.setString(1, email);
			this.pst.setInt(2, customerId);
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
					
					this.pst.setInt(1, customerId);
					
					this.rs = this.pst.executeQuery();
					
					if(this.rs.next()){
						return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
							
					}
				}catch (SQLException e) {
					System.out.println("error in return");
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public Customer editPassword(String password, int customerId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("update customer_info set password = ? where customer_id = ?");
			
			this.pst.setString(1, password);
			this.pst.setInt(2, customerId);
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
					
					this.pst.setInt(1, customerId);
					
					this.rs = this.pst.executeQuery();
					
					if(this.rs.next()){
						return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
							
					}
				}catch (SQLException e) {
					System.out.println("error in return");
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public Customer editMobileNo(String mobileNo, int customerId) {
		
		this.con = DatabaseConnection.getConnection();
		
		try {
			
			this.pst = this.con.prepareStatement("update customer_info set contact_no = ? where customer_id = ?");
			
			this.pst.setString(1, mobileNo);
			this.pst.setInt(2, customerId);
			
			int i = this.pst.executeUpdate();
			
			if(i > 0) {
				
				try {
					this.pst = this.con.prepareStatement("select customer_id, first_name, last_name, email, contact_no from customer_info where customer_id = ?");
					
					this.pst.setInt(1, customerId);
					
					this.rs = this.pst.executeQuery();
					
					if(this.rs.next()){
						return new Customer(rs.getInt("customer_Id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"));
							
					}
				}catch (SQLException e) {
					System.out.println("error in return");
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
		
	
	
}
