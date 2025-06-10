package hotel.structures;

public class Date {
	public int  day;
	public int month;
	public int year;
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
		assert (-1 < day && day < 31 && -1 < month && month < 13 && 2024 < year && year < 2028);
	}
	
	
	
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
	
	public int getDifference(Date date) {
		int comp =  compare(date);
		if (comp < 1) return 360*(date.year - year) + 30*(date.month - month) + (date.day - day);
		else if (comp > 1) return 360*(year - date.year) + 30*(month - date.month) + (day - date.day);
		return 0;
	}
}