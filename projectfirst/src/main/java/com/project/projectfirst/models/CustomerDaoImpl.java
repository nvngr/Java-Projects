package com.project.projectfirst.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
	Connection connection = ConnectionDB.getConnection();

	@Override
	public Customer addCustomer(Customer customer) {
		try {
		   PreparedStatement ps = connection.prepareStatement("insert into customer(CustomerId,Name,Contact,Address) values(?,?,?,?)");
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getContact());
			ps.setString(4, customer.getAddress());
			
			int i=ps.executeUpdate();
			if(i>0)
				System.out.println("Customer added succesfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer not added ..somethong went wrong");
			e.printStackTrace();
		}
		  return null;
		}

		
	

	@Override
	public Customer getCustomer(int id) {
		Customer customer=new Customer();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from customer where CustomerId=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setName(rs.getString("name"));
				customer.setContact(rs.getString("contact"));
				customer.setAddress(rs.getString("address"));
				return customer;
			}
			else
			{
				System.out.println("Sorry there is no such customer here with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the book");
			e.printStackTrace();
		
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from customer ");
		   	ResultSet rs=ps.executeQuery();
		   	
			while(rs.next())
			{		
				Customer customer=new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setName(rs.getString("name"));
				customer.setContact(rs.getString("contact"));
				customer.setAddress(rs.getString("address"));
				customerList.add(customer);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the customer info...");
			e.printStackTrace();
			return null;
		}
		return customerList;

		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		 try {
				PreparedStatement ps=connection.prepareStatement("update customer set Name=?,Contact=?,Address=? where CustomerId=?");
				ps.setString(1, customer.getName());
				ps.setString(2, customer.getContact());
				ps.setString(3, customer.getAddress());
				ps.setInt(4, customer.getCustomerId());
				int i=ps.executeUpdate();
				if(i>0)
					System.out.println("Book updated succesfully");
				
			} catch (SQLException e) {
				System.out.println("Book not updated ..somethong went wrong");
				e.printStackTrace();
			}
			  return customer;
	}

	@Override
	public Customer deleteCustomer(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from customer where CustomerId=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
				
			{	
				System.out.println("Customer removed Suucessfully.");
				return null;
			}
			System.out.println("Customer does not removed");
		} catch (SQLException e) {
			System.out.println("Customer not deleted ...something went wrong");
			e.printStackTrace();
		return null;
		}
		return null;
	     
		
	}
	
		 
}
