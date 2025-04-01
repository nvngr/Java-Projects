package com.project.projectfirst.models;

public class Room {
	private int roomId;
	private String roomType;
	private int price;
	private String available;



	public Room() {
		super();
	}
	public Room(int roomId, String roomType, int price, String available) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.available = available;
	 
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
	   this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public String toString() {
		//System.out.printf("%-15d %-15s %-15d %-15s\n", "RoomId" , "RoomType", "Price" , "Available");
		System.out.printf("%-15d %-15s %-15d %-15s\n", roomId , roomType, price , available);
		return ""; 
	}

	}


