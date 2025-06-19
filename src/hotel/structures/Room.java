package hotel.structures;
import java.util.*;


/**
 * The Room class is here to keep track of every reservation within each room, as well as their type.
 */
public class Room {
		
		char type;
		public LinkedList<Reservation> reservations = new LinkedList<Reservation>();
		
		public Room(char type) {
			this.type = type;
		}
		
		/**
		 * checkAvailable takes one Reservation and returns an integer array of two digits:
		 * The first integer will be equivalent to the index the reservation should be added to ensure it is ordered by date,
		 * the second integer will represent how much free space is between the new reservation and the pre-existing ones (used for Best-Fit
		 * Algorithm).
		 */
		public int[] checkAvailable(Reservation newReservation, Date current_date) {	
			if (reservations.isEmpty() || reservations.get(0).start.compare(newReservation.end) > 0) {
				System.out.println("Empty Room/First Reservation");
				int[] ans = {0, current_date.getDifference(newReservation.start) + newReservation.end.getDifference(reservations.get(0).start)};
				System.out.println("Empty Room/First Reservation");
				return ans;
			}
			
			Reservation previous = reservations.get(0);
			Reservation current;
			int size = reservations.size();
			for (int index = 1; index < size; index++) {
				current = reservations.get(index);
				if (current.end.compare(newReservation.start) < 0) {
					previous = current;
					continue;
				}
				else if (previous.end.compare(newReservation.start) > 0 && current.start.compare(newReservation.end) < 0) {
					int[] ans = {index, previous.end.getDifference(newReservation.start) + newReservation.end.getDifference(current.start)};
					return ans;
				}
				else break;
			}
			int[] ans = {-1, -1};
			return ans;
		}
		
		/**
		 * addNewReservation(Reservation, Date) tries to add a reservation to the LinkedList and returns how much space will there be
		 * between the new reservation and the pre-existing reservations for a BestsFit algorithm on another class.
		 * returns -1 if the operation was not successful.
		 */
		public int addNewReservation(Reservation reservation, Date current_date) {
			// index_space[0] = index | index_space[1] = space
			int[] index_space = checkAvailable(reservation, current_date);
			if (index_space[0] != -1) {
				reservations.add(index_space[0], reservation);
				return index_space[1];
			}
			return -1;
		}
		
		/**
		 * The function addReservations is to be used to add reservations from the database when this variable is first created.
		 */
		public void addReservation(Reservation reservation) {
			reservations.add(reservation);
		}
		
		/**
		 * The function sortReservations is to be used after all the reservations from the database are inserted, it sorts
		 * all the reservations by start date in order to ensure that the function checkAvailable works as intended.
		 */
		public void sortReservations() {
			Collections.sort(reservations, new SortByStartDate());
		}
}

/**
 * this class is used simply to utilize Collections.sort()
 */
class SortByStartDate implements Comparator<Reservation>{

	@Override
	public int compare(Reservation r1, Reservation r2) {
		// TODO Auto-generated method stub
		return r1.start.compare(r2.start);
	}

}
