/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	/**
	 * Prints the calendars of all the years in the 20th century. Also prints the
	 * number of Sundays that occured on the first day of the month during this
	 * period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
		// inclusive.
		// Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
		// prints "Sunday".
		// The following variable, used for debugging purposes, counts how many days
		// were advanced so far.
		int givenYear = Integer.parseInt(args[0]);

		//Checks the days until the given days
		while (year < givenYear) {
			advance();
		}

		while (year < (givenYear + 1)) {
			System.out.print(dayOfMonth + "/" + month + "/" + year);
			if (dayOfWeek == 1) {
				System.out.print(" Sunday");
			}
			System.out.println();
			advance();
		}
	}

	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year,
	// dayOfWeek, nDaysInMonth.
	private static void advance() {
		if (dayOfWeek != 7) {
			dayOfWeek++;
		} else {
			dayOfWeek = 1;
		}

		if (dayOfMonth == nDaysInMonth(month, year)) {
			if (month == 12) {
				year++;
				month = 1;
				dayOfMonth = 1;
			} else {
				month++;
				dayOfMonth = 1;
			}
		} else {
			dayOfMonth++;
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear;
		// Checks if the year is divisible by 400
		isLeapYear = ((year % 400) == 0);
		// Then checks if the year is divisible by 4 but not by 100
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}

	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int daysInMonth = 0;
		switch (month) {
			case 1:
				daysInMonth = 31;
				break;
			case 2:
				if (isLeapYear(year)) {
					daysInMonth = 29;
				} else {
					daysInMonth = 28;
				}
				break;
			case 3:
				daysInMonth = 31;
				break;
			case 4:
				daysInMonth = 30;
				break;
			case 5:
				daysInMonth = 31;
				break;
			case 6:
				daysInMonth = 30;
				break;
			case 7:
				daysInMonth = 31;
				break;
			case 8:
				daysInMonth = 31;
				break;
			case 9:
				daysInMonth = 30;
				break;
			case 10:
				daysInMonth = 31;
				break;
			case 11:
				daysInMonth = 30;
				break;
			case 12:
				daysInMonth = 31;
				break;
		}

		return daysInMonth;
	}
}
