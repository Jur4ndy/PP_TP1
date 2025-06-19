package hotel.structures;

/**
 * The class Reservation will keep track of all the relevant information for each reservation, most notably their start and end Dates.
 */

public class Reservation {
	public int cpf;
	public int RoomID;
	public Date start;
	public Date end;
	
	public Reservation(int cpf, Date startDate, Date endDate) {
		this.cpf = cpf;
		this.start = startDate;
		this.end = endDate;
	}
	
	public Reservation(int cpf, Date startDate, Date endDate, int RoomID) {
		this.cpf = cpf;
		this.start = startDate;
		this.end = endDate;
		this.RoomID = RoomID;
	}
	
	public String toString() {
		return ("from " + start.day + "/" + start.month + "/" + start.year + " to " + end.day + "/" + end.month + "/" + end.year + " at Room " + RoomID);
	}
}
