package hotel.structures;
import java.util.*;



public class Room {
		char type;
		LinkedList<Reservation> reservations = new LinkedList<Reservation>();
		
		public Room(char type) {
			this.type = type;
		}
		
		/**
		 * checkAvailable takes one Reservation and returns an integer array of two digits
		 * the first integer will be equivalent to the index the reservation should be added to in order to make it ordered by date
		 * the second integer will represent how much free space is between the new reservation and the pre-existing ones.
		 */
		public int[] checkAvailable(Reservation newR, Date current_date) {	
			int[] ans = new int[2];
			if (reservations.isEmpty() || reservations.get(0).start.compare(newR.end) > 0) {
				ans[0] = 0;
				ans[1] = current_date.getDifference(newR.start) + newR.end.getDifference(reservations.get(0).start);
				return ans;
			}
			
			Reservation previous = reservations.get(0);
			Reservation current;
			int size = reservations.size();
			for (int index = 1; index < size; index++) {
				current = reservations.get(index);
				if (current.end.compare(newR.start) < 0) {
					previous = current;
					continue;
				}
				else if (previous.end.compare(newR.start) > 0 && current.start.compare(newR.end) < 0) {
					ans[0] = index;
					ans[1] = previous.end.getDifference(newR.start) + newR.end.getDifference(current.start);
					return ans;
				}
				else break;
			}
			ans[0] = -1;
			ans[1] = -1;
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
		 * 
		 * The function sortReservations is to be used after all the reservations from the database are inserted, it sorts
		 * all the reservations by start date in order to ensure that the function checkAvailable works as intended.
		 */
		public void addReservation(Reservation reservation) {
			reservations.add(reservation);
		}
		
		public void sortReservations() {
			Collections.sort(reservations, new SortByStartDate());
		}
}

class SortByStartDate implements Comparator<Reservation>{

	@Override
	public int compare(Reservation r1, Reservation r2) {
		// TODO Auto-generated method stub
		return r1.start.compare(r2.start);
	}

}
