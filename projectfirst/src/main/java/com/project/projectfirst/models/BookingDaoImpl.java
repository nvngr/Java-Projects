package com.project.projectfirst.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDAO{

	Connection connection = ConnectionDB.getConnection();
	public Booking addBooking(Booking booking) {
		try {
			PreparedStatement ps = connection.prepareStatement("insert into booking(BookingId,CustomerId,RoomId,CheckInDate,CheckOutDate) values(?,?,?,?,?)");
			ps.setInt(1, booking.getBookingId());
			ps.setInt(2, booking.getCustomerId());
			ps.setInt(3, booking.getRoomId());
			ps.setDate(4, booking.getCheckInDate());
			ps.setDate(5, booking.getCheckOutDate());
			int i=ps.executeUpdate();
			if(i>0)
				System.out.println("Booking added succesfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Booking not added ..somethong went wrong");
			e.printStackTrace();
		}
		  return booking ;
	}
	
	
	@Override
	public Booking getBookingInfoById(int id) {
		Booking booking=new Booking();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from booking where BookingId=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				booking.setBookingId(rs.getInt("BookingId"));
				booking.setCustomerId(rs.getInt("CustomerId"));
				booking.setRoomId(rs.getInt("RoomId"));
				booking.setCheckInDate(rs.getDate("CheckInDate"));
				booking.setCheckOutDate(rs.getDate("CheckOutDate"));
				return booking;
			}
			else
			{
				System.out.println("Sorry there is no such booking here with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the booking");
			e.printStackTrace();
			   return null;
	}
	}

	@Override
	public Booking deleteBooking(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from booking where BookingId=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{	
				System.out.println("Booking removed Suucessfully.");
				return null;
			}
			System.out.println("Booking does not removed");
		} catch (SQLException e) {
			System.out.println("Booking not deleted ...something went wrong");
			e.printStackTrace();
		return null;
		}
		return null;
	    
	}

	@Override
	public Booking updateBooking(Booking booking) {
		try {
			PreparedStatement ps=connection.prepareStatement("update booking set CustomerId=?,RoomId=?,CheckInDate=?,CheckOutDate=? where BookingId=?");
			ps.setInt(1, booking.getCustomerId());
			ps.setInt(2, booking.getRoomId());
			ps.setDate(3, booking.getCheckInDate());
			ps.setDate(4, booking.getCheckOutDate());
			ps.setInt(5, booking.getBookingId());
			int i=ps.executeUpdate();
			if(i>0)
				System.out.println("Booking updated succesfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Booking not updated ..somethong went wrong");
			e.printStackTrace();
		}
		  return booking;
}

	

	@Override
	public List<Booking> getAllBookingInfo() {
		List<Booking> bookingList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from booking ");
		   	ResultSet rs=ps.executeQuery();
		    
			while(rs.next())
			{			
				Booking booking=new Booking();
				booking.setBookingId(rs.getInt("BookingId"));
				booking.setCustomerId(rs.getInt("CustomerId"));
				booking.setRoomId(rs.getInt("RoomId"));
				booking.setCheckInDate(rs.getDate("CheckInDate"));
				booking.setCheckOutDate(rs.getDate("CheckOutDate"));
				bookingList.add(booking);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the BookinhInfo");
			e.printStackTrace();
		}
		return bookingList;

	}


	

}
