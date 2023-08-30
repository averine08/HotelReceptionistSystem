package Model;

public class RoomType {
	private int roomTypeId;
	private String name;
	private int pricePerNight;
	
	public RoomType(int roomTypeId, String name, int pricePerNight) {
		this.roomTypeId = roomTypeId;
		this.name = name;
		this.pricePerNight = pricePerNight;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPricePerNight() {
		return pricePerNight;
	}
	
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}	
}
