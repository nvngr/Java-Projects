package com.project.projectfirst.models;

import java.sql.Date;

public class Booking {
		private int BookingId;
		private int CustomerId;
		private int RoomId;
		private Date CheckInDate;
		private Date CheckOutDate;
		
		
		public Booking() {
			super();
			
		}
		public Booking(int bookingId, int customerId, int roomId, Date checkInDate, Date checkOutDate) {
			super();
			BookingId = bookingId;
			CustomerId = customerId;
			RoomId = roomId;
			CheckInDate = checkInDate;
			CheckOutDate = checkOutDate;
		}
		public int getBookingId() {
			return BookingId;
		}
		public void setBookingId(int bookingId) {
			BookingId = bookingId;
		}
		public int getCustomerId() {
			return CustomerId;
		}
		public void setCustomerId(int customerId) {
			CustomerId = customerId;
		}
		public int getRoomId() {
			return RoomId;
		}
		public void setRoomId(int roomId) {
			RoomId = roomId;
		}
		public Date getCheckInDate() {
			return CheckInDate;
		}
		public void setCheckInDate(Date checkInDate) {
			CheckInDate = checkInDate;
		}
		public Date getCheckOutDate() {
			return CheckOutDate;
		}
		public void setCheckOutDate(Date checkOutDate) {
			CheckOutDate = checkOutDate;
		}
		@Override
		public String toString() {
			System.out.printf("%-15d %-15d %-15d %-15s %-15s\n", BookingId , CustomerId, RoomId , CheckInDate , CheckOutDate);
			return ""; 
		}
		
		}
		
		
		
		

	




