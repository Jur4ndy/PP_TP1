package hotel.structures;
import java.util.*;

/**
 * The Hotel class will manage all the rooms in the
 */

public class Hotel {
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	public Hotel() {
		
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void addReservation(Reservation reservation, int roomID) {
		rooms.get(roomID).addReservation(reservation);
	}
	
}
