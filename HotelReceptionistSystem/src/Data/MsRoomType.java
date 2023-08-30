package Data;

import java.util.ArrayList;

import Model.RoomType;

public class MsRoomType {
	private static ArrayList<RoomType> msRoomType = new ArrayList<>();
	
	public MsRoomType() {
		
	}
	
	public void generateDummyData() {
		msRoomType.add(new RoomType(1, "VIP", 500000));
		msRoomType.add(new RoomType(2, "Family", 250000));
		msRoomType.add(new RoomType(3, "Personal", 100000));
	}
	
	public ArrayList<RoomType> getAllRoomTypeList() {
		return msRoomType;
	}
	
	public RoomType getRoomTypeById(int roomTypeId) {
		return msRoomType.stream().filter(roomType -> roomType.getRoomTypeId() == roomTypeId).findFirst().get();
	}
}
