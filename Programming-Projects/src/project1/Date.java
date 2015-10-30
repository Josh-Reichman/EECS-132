//Josh Reichman
//Manages dates
package project1;

public class Date {

	private int day;
	private int month;

	public Date(int d, int m) {
		day = d;
		month = m;
	}

	public int getDay() {
		return day;
	}

	public int getmonth() {
		return month;
	}

	// 31d: January, March, May, July, August, October, & December
	// (1,3,5,7,8,10,12)
	// 30d: April, June, September, & November (4,6,9,11)
	// 28d: February (28)
	public void incrementDay() {

		if (month == 12) {
			if (day == 31) {
				month = 1;
				day = 1;
			}
			else
				day++;
		}
		if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
			if (day == 31) {
				month++;
				day = 1;
			}
			else
				day++;
		}
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			if (day == 30) {
				month++;
				day = 1;
			}
			else
				day++;
		}
		if (month == 2) {
			if (day == 28) {
				month++;
				day = 1;
			}
			else
				day++;

		}
	}
}