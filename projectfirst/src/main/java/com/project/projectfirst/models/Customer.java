package com.project.projectfirst.models;

public class Customer {
	private int customerId;
	private String name;
	private String contactInfo;
	private String address;
	
	
	
	public Customer() {
		super();
		
	}
	public Customer(int customerId, String name, String contact, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		contactInfo = contact;
		this.address = address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contactInfo;
	}
	public void setContact(String contact) {
		contactInfo = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		System.out.printf("%-15d %-15s %-15s %-15s\n", customerId , name, contactInfo , address);
		return ""; 
	
	}
	
}



