package hotel.structures;

/**
 * The classes Reservation and Date are simply here to make the code in the "Room.java" class easier to read;
 */

public class Reservation {
	public int cpf;
	public Date start;
	public Date end;
	
	public Reservation(int cpf, Date startDate, Date endDate) {
		this.cpf = cpf;
		this.start = startDate;
		this.end = endDate;
	}
}
