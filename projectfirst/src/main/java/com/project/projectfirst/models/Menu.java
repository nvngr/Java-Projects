package com.project.projectfirst.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

public class Menu{
		
		public static void displayMenu() throws NumberFormatException, IOException
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			RoomDAO roomdao=new RoomDaoImpl();
			CustomerDAO customerdao=new CustomerDaoImpl();
			BookingDAO bookingdao=new BookingDaoImpl();
			
			int ch;
			int ch1;
			int ch2;
			int ch3;
			do{			
			System.out.println("Enter the number given below to get the requered info... ");
			System.out.println("1. Customer Info");
			System.out.println("2. Room Info");
			System.out.println("3. Booking Info");
			System.out.println("4. Exit");
			
			System.out.println("Enter Your Choice");
			
			ch=Integer.parseInt(br.readLine());
			
			switch(ch)
			{
			case 1:{
				
				do {
				System.out.println("1.Add Customer");
			    System.out.println("2.View Customer");
			    System.out.println("3.View All Customers");
			    System.out.println("4.Update Customer");
			    System.out.println("5.Delete Customer");
			    System.out.println("6.Exit");
			    
			    System.out.println("Enter your Choice :");
			  
			    ch1=Integer.parseInt(br.readLine());
			    
			    switch(ch1)
			    {
			    case 1:{
			    	System.out.println("Enter Customer Id :");
			    	int customerId=Integer.parseInt(br.readLine());
			    	System.out.println("Enter Customer Name :");
			    	String name=br.readLine();
			    	System.out.println("Enter contact :");
			    	String contact=br.readLine();
			    	System.out.println("Enter Address :");
			    	String address=br.readLine();
			    	
			    	Customer customer=new Customer(customerId,name,contact,address);
			    	customerdao.addCustomer(customer);
			       break;
			    	
			    }
			    case 2:{
			    	System.out.println("Enter Customer Id :");
			    	int customerId=Integer.parseInt(br.readLine());
			    	Customer customer=customerdao.getCustomer(customerId);
			    	System.out.println(customer);
			    	break;
			    }
			    case 3:{
			    	List<Customer> customerList=customerdao.getAllCustomer();
			    	System.out.printf("%-15s %-15s %-15s %-15s\n", "CustomerId" , "Name", "Contact" , "Address");
			    	System.out.println("-------------------------------------------------------------------------------------------------------------------");
			    	for(Customer customer:customerList)
			    		System.out.println(customer);
			    	break;
			    }
			    case 4:{
			    	System.out.println("Enter Customer Id :");
			    	int customerId=Integer.parseInt(br.readLine());
			    	Customer customer=customerdao.getCustomer(customerId);
			    	if(customer==null)
			    		return;
			    	System.out.println("Enter Customer Name :");
			    	String name=br.readLine();
			    	System.out.println("Enter Address :");
			    	String address=br.readLine();
			    	System.out.println("Enter Contact :");
			    	String contact=br.readLine();
			    	
			    	Customer customer1=new Customer(customerId,name,contact,address);
			    	customerdao.updateCustomer(customer1);
			    	break;
			    }
			    case 5:{
			    	System.out.println("Enter Customer Id :");
			    	int customerId=Integer.parseInt(br.readLine());
			    	Customer customer =customerdao.getCustomer(customerId);
			    	if(customer==null)
			    		return;
			    	customerdao.deleteCustomer(customerId);
			    	break;
			    }
			    case 6:{
			    	System.out.println("Exit");
			    	break;
			   }
			    default :System.out.println("Please enter a valid choice");
			    }
			    }while(ch1!=6);
				break;
			}
			 
			case 2:{
				
				
				do {
		    System.out.println("1.Add Room");
		    System.out.println("2.View Room");
		    System.out.println("3.View All Rooms");
		    System.out.println("4.Update Room");
		    System.out.println("5.Delete Room");
		    System.out.println("6.Exit");
				
		    System.out.println("Enter your Choice :");
		  
		    ch2=Integer.parseInt(br.readLine());
		    
		    switch(ch2)
		    {
		    case 1:{
		    	System.out.println("Enter Room Id :");
		    	int roomId=Integer.parseInt(br.readLine());
		    	System.out.println("Enter Room Type :");
		    	String roomType=br.readLine();
		    	System.out.println("Enter Room Price :");
		    	int price=Integer.parseInt(br.readLine());
		    	System.out.println("Enter Availability :");
		    	String availability=br.readLine();
		    	
		    	Room room=new Room(roomId,roomType,price,availability);
		    	roomdao.addRoom(room);
		       break;
		    	
		    }
		    case 2:{
		    	System.out.println("Enter Room Id :");
		    	int roomId=Integer.parseInt(br.readLine());
		    	Room room=roomdao.getRoomById(roomId);
		    	System.out.println(room);
		    	break;
		    }
		    case 3:{
		    	List<Room> roomList=roomdao.getAllRooms();
		    	System.out.printf("%-15s %-15s %-15s %-15s\n", "RoomId" , "RoomType", "Price" , "Available");
		    	System.out.println("------------------------------------------------------------------------------------------------------");
		    	for(Room room:roomList)
		    		System.out.println(room);
		    	break;
		    }
		    case 4:{
		    	System.out.println("Enter Room Id :");
		    	int roomId=Integer.parseInt(br.readLine());
		    	Room room=roomdao.getRoomById(roomId);
		    	if(room==null)
		    		return;
		    	System.out.println("Enter Room Type :");
		    	String roomType=br.readLine();
		    	System.out.println("Enter Availability :");
		    	String availability=br.readLine();
		    	System.out.println("Enter Room Price :");
		    	int price=Integer.parseInt(br.readLine());
		    	
		    	Room room1=new Room(roomId,roomType,price,availability);
		    	roomdao.updateRoom(room1);
		    	break;
		    }
		    case 5:{
		    	System.out.println("Enter Room Id :");
		    	int roomId=Integer.parseInt(br.readLine());
		    	Room room =roomdao.getRoomById(roomId);
		    	if(room==null)
		    		return;
		    	roomdao.deleteRoom(roomId);
		    	break;
		    }
		    case 6:{
		    	System.out.println("Exit");
		    	break;
		    }
		    default :System.out.println("Please enter a valid choice");
		    }
		    }while(ch2!=6);
				break;
			}
			case 3:{
				
				do {
				    System.out.println("1.Add Booking");
				    System.out.println("2.View Booking");
				    System.out.println("3.Update Booking");
				    System.out.println("4.View All Booking");
				    System.out.println("5.Delete Booking");
				    System.out.println("6.Exit");
				
				    
				    	System.out.println("Enter your Choice :");
				  
				    ch3=Integer.parseInt(br.readLine());
				    
				    switch(ch3)
				    {
				    case 1:{
				    	System.out.println("Enter Booking Id :");
				    	int bookingId=Integer.parseInt(br.readLine());
				    	System.out.println("Enter Customer Id :");
				    	int customerId=Integer.parseInt(br.readLine());
				    	System.out.println("Enter Room Id :");
				    	int roomId=Integer.parseInt(br.readLine());
				    	System.out.println("Enter CheckInDate in YYYY-MM-DD :");
				    	String date= br.readLine();
				    	//LocalDate checkInDate=LocalDate.parse(date);
				    	Date checkInDate=Date.valueOf(date);
				    	System.out.println("Enter CheckOutDate in YYYY-MM-DD :");
				    	String date1= br.readLine();
				    	
				    	//LocalDate checkOutDate=LocalDate.parse(date1);
				    	Date checkOutDate=Date.valueOf(date1);
				    	//Date date2 =Date.valueOf(date1);
                                  //  Date.parse(date1);
				    	Booking booking=new Booking(bookingId,customerId,roomId,checkInDate,checkOutDate);
				    	bookingdao.addBooking(booking);
				         break;
				    }
				    case 2:
				    {
				    	System.out.println("Enter Booking Id :");
				    	int bookingId=Integer.parseInt(br.readLine());
				    	Booking booking=bookingdao.getBookingInfoById(bookingId);
				    	System.out.println(booking);
				    	break;
				    	
				    }
				    
				    case 3:
				    {
				    	System.out.println("Enter Booking Id :");
				    	int bookingId=Integer.parseInt(br.readLine());
				    	Booking booking=bookingdao.getBookingInfoById(bookingId);
				    	if(booking==null)
				    		return;
				    	System.out.println("Enter Customer Id :");
				    	int customerId=Integer.parseInt(br.readLine());
				    	System.out.println("Enter Room Id :");
				    	int roomId=Integer.parseInt(br.readLine());
				    	System.out.println("Enter CheckInDate in YYYY-MM-DD :");
				    	String date= br.readLine();
				    	Date checkInDate=Date.valueOf(date);
				    	
				    	System.out.println("Enter CheckInDate in YYYY-MM-DD :");
				    	String date1= br.readLine();
				    	Date checkOutDate=Date.valueOf(date1);
				    	
				    	Booking booking1=new Booking(bookingId,customerId,roomId,checkInDate,checkOutDate);
				    	bookingdao.updateBooking(booking1);
				    	break;
				    }
				    case 4:
				    {
				    	List<Booking> bookingList=bookingdao.getAllBookingInfo();
				    	System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "BookingId" , "CustomerId", "RoomId" , "CheckInDate", "CheckOutDate");
				    	System.out.println("-------------------------------------------------------------------------------------------------------------------");
				    	for(Booking booking:bookingList)
				    		System.out.println(booking);
				    	break;
				    }
				    
				    case 5:
				    {
				    	System.out.println("Enter Booking Id :");
				    	int bookingId=Integer.parseInt(br.readLine());
				    	Booking booking =bookingdao.getBookingInfoById(bookingId);
				    	if(booking==null)
				    		return;
				    	bookingdao.deleteBooking(bookingId);
				    	break;
				    }   	
				    
				    case 6:
				    {
				    	System.out.println("Exit");
				    	break;
				    }
				    
				    default :System.out.println("Please enter a valid choice");

				    }
				    }while(ch3!=6);
				break;
			}
				
			case 4:{
			  	System.out.println("Exit");
			  	break;
			}
			default : System.out.println("Please enter a valit choice");
				    }
			
			
			}while(ch!=4);
			
			
			}
}


