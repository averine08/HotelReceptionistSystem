package Model;

import Data.*;

public class Room {
	private int roomNumber;
	private int roomTypeId;
	private boolean filled;
	
	public Room(int roomNumber, int roomTypeId, boolean filled) {
		this.setRoomNumber(roomNumber);
		this.setRoomTypeId(roomTypeId);
		this.setFilled(filled);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeID) {
		this.roomTypeId = roomTypeID;
	}
	
	public RoomType getRoomType() {
		return new MsRoomType().getRoomTypeById(roomTypeId);
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}