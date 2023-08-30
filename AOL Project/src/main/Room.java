package main;

public class Room {
	private int TypeID;
	private int roomNumber;
	private int roomPricePerNight;
	private boolean filled;
	private String roomType;
	
	public Room(int TypeID, int roomNumber, boolean filled) {
		this.setTypeID(TypeID);
		this.setRoomNumber(roomNumber);
		this.setfilled(filled);
		this.setRoomPricePerNight(new RoomType(TypeID).getPrice());
		this.setRoomType(new RoomType(TypeID).getName());
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getRoomPricePerNight() {
		return roomPricePerNight;
	}

	public void setRoomPricePerNight(int roomPricePerNight) {
		this.roomPricePerNight = roomPricePerNight;
	}

	public boolean isfilled() {
		return filled;
	}

	public void setfilled(boolean filled) {
		this.filled = filled;
	}

	public int getTypeID() {
		return TypeID;
	}

	public void setTypeID(int typeID) {
		TypeID = typeID;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomTypeName) {
		this.roomType = roomTypeName;
	}
	

}
