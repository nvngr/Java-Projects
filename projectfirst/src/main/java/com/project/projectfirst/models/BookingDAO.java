package com.project.projectfirst.models;

import java.util.List;

public interface BookingDAO {
	public Booking addBooking(Booking booking);
	public Booking getBookingInfoById(int id);
	public Booking deleteBooking(int id);
	public Booking updateBooking(Booking booking);
	public List<Booking> getAllBookingInfo();
}
