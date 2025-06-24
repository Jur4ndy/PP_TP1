package hotel.structures;
import java.util.*;

/**
 * The Hotel class will manage all the rooms and their reservations.
 * The Hotel will have 25 suites, 10 doubles and 5 presidential suites by default.
 */

public class Hotel {
	//change this value to set current date
	public static Date current_date = new Date(1, 1, 2025);
	public static int size = 40;
	public ArrayList<Room> rooms = new ArrayList<Room>();
	
	public Hotel() {
		//25 Singles
		for (int i = 0; i < 25; i++) {
			rooms.add(new Room('S'));
		}
		//10 Doubles
		for (int i = 0; i < 10; i++) {
			rooms.add(new Room('D'));
		}
		//5 Presidential Suites
		for (int i = 0; i < 5; i++) {
			rooms.add(new Room('P'));
		}
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void addReservation(Reservation reservation, int roomID) {
		rooms.get(roomID).addReservation(reservation);
	}
	
	/**
	 * checkAvailable checks if there are any rooms available for this specific reservation and returns the roomID and the
	 * index where the reservation should happen
	 */
	public int[] checkAvailable(Reservation reservation, char type) {
		int id = -1;
		int min = Integer.MAX_VALUE;
		int roomID = 0;
		int index = -1;
		for(Room room : rooms) {
			if (room.type != type) {roomID++; continue;} 
			int[] aux = room.checkAvailable(reservation, current_date);
			if (aux[1] < min && aux[0] != -1) {
				id = roomID;
				min = aux[1];
				index = aux[0];
			}
			roomID++;
		}
		int[] r = {id, index};
		return r;		
	}
	
	/**
	 * gets the amount of reservations in each room.
	 */
	public LinkedList<Integer> getOccupied() {
		LinkedList<Integer> r = new LinkedList<Integer>();
		for (Room room : rooms) {
			r.add(room.reservations.size());
		}
		return r;
	}
}
