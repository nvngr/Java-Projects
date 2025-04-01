package com.project.projectfirst.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDAO{
	Connection connection = ConnectionDB.getConnection();
    

	public Room addRoom(Room room) {
	 try {
		PreparedStatement ps = connection.prepareStatement("insert into room(RoomId,RoomType,Price,Available) values(?,?,?,?)");
		ps.setInt(1, room.getRoomId());
		ps.setString(2, room.getRoomType());
		ps.setInt(3, room.getPrice());
		ps.setString(4, room.getAvailable());
		
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("Book added succesfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Book not added ..something went wrong");
		e.printStackTrace();
	}
	  return room ;
	}
	
	
	public Room getRoomById(int id)  {
		Room room=new Room();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from room where RoomId=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				room.setRoomId(rs.getInt("roomId"));
				room.setRoomType(rs.getString("roomType"));
				room.setPrice(rs.getInt("price"));
				room.setAvailable(rs.getString("available"));
				return room;
			}
			else
			{
				System.out.println("Sorry there is no book with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the book");
			e.printStackTrace();
		
			return null;
		}
	}
		public List<Room> getAllRooms(){
			List<Room> roomList=new ArrayList<>();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from room ");
			   	ResultSet rs=ps.executeQuery();
			   	
				while(rs.next())
				{	
					Room room=new Room();		
					room.setRoomId(rs.getInt("roomId"));
					room.setRoomType(rs.getString("roomType"));
					room.setPrice(rs.getInt("price"));
					room.setAvailable(rs.getString("available"));
					roomList.add(room);
				}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Somethong went wrong in getting the rooms");
				e.printStackTrace();
			}
			return roomList;
		
	}
		
		
		
		public Room updateRoom(Room room) {
			 try {
					PreparedStatement ps=connection.prepareStatement("update room set RoomType=?,Price=?,Available=? where RoomId=?");
					ps.setString(1, room.getRoomType());
					ps.setInt(2, room.getPrice());
					ps.setString(3, room.getAvailable());
					ps.setInt(4, room.getRoomId());
					int i=ps.executeUpdate();
					if(i>0)
						System.out.println("Book updated succesfully");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Book not updated ..somethong went wrong");
					e.printStackTrace();
				}
				  return room;
		}

		public String deleteRoom(int id) {
			
			try {
				PreparedStatement ps = connection.prepareStatement("delete from room where RoomId=?");
				ps.setInt(1, id);
				int i=ps.executeUpdate();
				if(i>0)
				{	
					System.out.println("room deleted Suucessfully.");
					return "Room Id= " +id+ "is not available now!";
				}
		return "room does not remove";
			} catch (SQLException e) {
				System.out.println("Room not deleted ...something went wrong");
				e.printStackTrace();
			return "Something went wrong";
			}
		     
			
		}


	

	

}


