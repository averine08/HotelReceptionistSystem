package Data;

import java.util.*;
import Model.Room;

public class MsRoom {
	private static ArrayList<Room> msRoom = new ArrayList<>();
	
	public MsRoom() {
		
	}
	
	public void generateDummyData() {
		msRoom.add(new Room(101, 3, true));
		msRoom.add(new Room(102, 3, false));
		msRoom.add(new Room(103, 3, false));
		msRoom.add(new Room(104, 2, true));
		msRoom.add(new Room(105, 1, true));
		msRoom.add(new Room(201, 3, false));
		msRoom.add(new Room(202, 3, false));
		msRoom.add(new Room(203, 3, false));
		msRoom.add(new Room(204, 2, true));
		msRoom.add(new Room(205, 1, false));
		msRoom.add(new Room(301, 3, true));
		msRoom.add(new Room(302, 3, false));
		msRoom.add(new Room(303, 3, false));
		msRoom.add(new Room(304, 2, false));
		msRoom.add(new Room(305, 1, false));
	}
	
	public ArrayList<Room> getAllRoomList() {
		return msRoom;
	};
	
	public Room getRoomByNumber(int roomNumber) {
		return msRoom.stream().filter(room -> room.getRoomNumber() == roomNumber).findFirst().get();
	}
	
	public void checkInToRoom(int roomNumber) {
		Room roomToCheckIn = msRoom.stream().filter(room -> room.getRoomNumber() == roomNumber).findFirst().get();
		
		msRoom.get(msRoom.indexOf(roomToCheckIn)).setFilled(true);
	}
	
	public void checkOutFromRoom(int roomNumber) {
		Room roomToCheckOut = msRoom.stream().filter(room -> room.getRoomNumber() == roomNumber).findFirst().get();
		
		msRoom.get(msRoom.indexOf(roomToCheckOut)).setFilled(false);
	}
}
