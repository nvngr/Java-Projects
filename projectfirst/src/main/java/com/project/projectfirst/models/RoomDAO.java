package com.project.projectfirst.models;

import java.util.List;

public interface RoomDAO {
	public Room addRoom(Room room );
	public Room getRoomById(int id);
	public List<Room> getAllRooms();
	public Room updateRoom(Room room);
	public String deleteRoom(int id);
	
}
