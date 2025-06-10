package hotel.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hotel.structures.ClientInfo;
import hotel.structures.Reservation;
import hotel.structures.Date;
import hotel.structures.Hotel;

public class ReservationDAO extends SQLDatabase {
	
	public Reservation getReservation(int cpf) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM Reservations WHERE " + 
	                                     "cpf='" + cpf + "'");
	      if (rs.next()) {
	    	 //return the existing reservation and its info
	        return new Reservation(cpf,
	        		new Date(rs.getInt(2), rs.getInt(3), rs.getInt(4)),
	        		new Date(rs.getInt(5), rs.getInt(6), rs.getInt(7)));
	        		
	      }
	      else return null;
	    }
	    catch (SQLException e) { return null; }
	  }
	
	public boolean addReservation (Reservation reservation) {
	    try {
	    	System.out.println(connection);
	    	Statement st = connection.createStatement();
	    	System.out.println(st);	    	//not sure if we are supposed to use the '' for integer values;
	    	int affected = st.executeUpdate("INSERT INTO Reservations VALUES('" + reservation.cpf + "', '"
	    			+ reservation.start.day +  "', '" + reservation.start.month +  "', '" + reservation.start.year +  "', '"
	            	+ reservation.end.day +  "', '" + reservation.end.month +  "', '" + reservation.end.year +  "')");
	    	if (affected > 0) return true  ;
	    	return false;
	    } catch (SQLException e) { return false; }
	  }
	
	public boolean getReservations (Hotel hotel) {
		try {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Reservations");
		Reservation reservation;
		Date start;
		Date end;
		while(rs.next()) {
			start = new Date(rs.getInt(2), rs.getInt(3), rs.getInt(4));
			end = new Date(rs.getInt(5),rs.getInt(6), rs.getInt(7));
			reservation = new Reservation(rs.getInt(0), start, end);	
			hotel.addReservation(reservation, rs.getInt(2));
		}
		return true;
		}
		catch(Exception e) { return false; }
	}
	
	public static void main(String[] args) {
		ReservationDAO d = new ReservationDAO();
		Reservation r = new Reservation(7, new Date(17, 5, 2026), new Date(18, 7, 2026));
		System.out.println(d.addReservation(r));
		SQLDatabase.disconnect();
	}
}
