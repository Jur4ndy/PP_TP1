package hotel.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import hotel.structures.ClientInfo;
import hotel.structures.Reservation;
import hotel.structures.Room;
import hotel.structures.Date;
import hotel.structures.Hotel;

/**
 * Class used to access HotelClients.Reservations Table.
 */
public class ReservationDAO extends SQLDatabase {
	
	/**
	 * Returns a LinkedList of every reservation associated with a certain CPF number, potentially returning an empty list.
	 * @param cpf
	 * @return
	 */
	public LinkedList<Reservation> getReservation(int cpf) {
	    try {
	      LinkedList<Reservation> reservations = new LinkedList<Reservation>();
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM Reservations WHERE " + 
	                                     "cpf='" + cpf + "'");
	      while (rs.next()) {
	    	 //return the existing reservation and its info
	        reservations.add(new Reservation(cpf,
	        		new Date(rs.getInt(3), rs.getInt(4), rs.getInt(5)),
	        		new Date(rs.getInt(6), rs.getInt(7), rs.getInt(8))
	        		,rs.getInt(2)));
	        		
	      }
	      return reservations;
	    }
	    catch (SQLException e) {System.out.println(e);  return null; }
	  }
	
	/**
	 * Stores a reservation to a certain room in the SQL Table
	 * @param reservation
	 * @param roomID
	 * @return
	 */
	public boolean addReservation (Reservation reservation, int roomID) {
	    try {
	    	System.out.println(connection);
	    	Statement st = connection.createStatement();
	    	System.out.println(st);	    	//not sure if we are supposed to use the '' for integer values;
	    	int affected = st.executeUpdate("INSERT INTO Reservations VALUES(" + reservation.cpf + ", " + roomID + ","
	    			+ reservation.start.day +  ", " + reservation.start.month +  ", " + reservation.start.year +  ", "
	            	+ reservation.end.day +  ", " + reservation.end.month +  ", " + reservation.end.year +  ")");
	    	if (affected > 0) return true  ;
	    	return false;
	    } catch (SQLException e) {System.out.println(e); return false; }
	  }
	
	public boolean getReservations (Hotel hotel) {
		try {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Reservations");
		Reservation reservation;
		Date start;
		Date end;
		while(rs.next()) {
			start = new Date(rs.getInt(3), rs.getInt(4), rs.getInt(5));
			end = new Date(rs.getInt(6),rs.getInt(7), rs.getInt(8));
			reservation = new Reservation(rs.getInt(1), start, end);	
			hotel.addReservation(reservation, rs.getInt(2));
		}
		return true;
		}
		catch(Exception e) {System.out.println(e); return false; }
	}

	//testing the code:
	
//	public static void main(String[] args) {
//		ReservationDAO d = new ReservationDAO();
//		Reservation r = new Reservation(7, new Date(17, 5, 2026), new Date(18, 7, 2026));
//		System.out.println(d.addReservation(r, 1));
//		Hotel hotel = new Hotel();
//		hotel.addRoom(new Room('S'));
//		hotel.addRoom(new Room('S'));
//		System.out.println(d.getReservations(hotel));
//		System.out.println(hotel.rooms.get(1).reservations.get(0).cpf);
//		SQLDatabase.disconnect();
//	}
}
