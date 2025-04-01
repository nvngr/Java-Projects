package com.project.projectfirst.models;

import java.util.List;

public interface CustomerDAO {
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int id);
	
}
