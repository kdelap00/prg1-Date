package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(14,11,2020);
			System.out.println(today);
			System.out.println(today.datesUntilEndOfMonth());
			System.out.println(today.monthsSameDays());
			System.out.println(today.daysUntilStartOfYear());
			System.out.println(today.attemptsRandomDateDoWhile());
			System.out.println(today.dayOfTheWeek(5));
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
