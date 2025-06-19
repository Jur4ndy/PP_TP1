package hotel.structures;

/**
 * Class used to store Dates, in Day, Month, Year format
 */
public class Date {
	public int  day;
	public int month;
	public int year;
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
		assert (-1 < day && day < 31 && -1 < month && month < 13 );
	}
	
	
	/**
	 * Used to compare if this date is earlier, equal or later than the given date
	 * @param date
	 * @return
	 */
	public int compare(Date date) {
		int yearCompare = Integer.compare(year, date.year);
		if (yearCompare == 0) {
			int monthCompare = Integer.compare(month, date.month);
			if (monthCompare == 0) {
				int dayCompare = Integer.compare(day, date.day);
				return dayCompare;
			}
			return monthCompare;
		}
		return yearCompare;
	}
	
	/**
	 * Used to add a certain number of days to the date, considering that day overflow will have to add to the months, and month overflow will
	 * add to the year
	 * @param days
	 * @return
	 */
	public Date add(int days) {
		int d = (day + days)%30;
		int m = month + (day + days)/30;
		int y = year + (month + (day + days)/30)/12;
		return new Date(d, m, y);
	}
	
	/**
	 * Gets the (absolute) difference between this date and the parameter
	 * @param date
	 * @return
	 */
	public int getDifference(Date date) {
		int comp =  compare(date);
		if (comp < 1) return 360*(date.year - year) + 30*(date.month - month) + (date.day - day);
		else if (comp > 1) return 360*(year - date.year) + 30*(month - date.month) + (day - date.day);
		return 0;
	}
}