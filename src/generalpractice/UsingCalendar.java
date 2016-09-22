package generalpractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class UsingCalendar {

	public void Run() {
		printingDates();
		workingWithDates();
	}

	private void printingDates() {
		String day = "20";
		String month = "01";
		String year = "1989";

		// Printing the current date
		Calendar c = Calendar.getInstance();
		System.out.println("Today is: " + new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
		System.out.println("Today is: " + new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));

		// Printing the current time
		System.out.println("The time is: " + new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
		System.out.println("The time is: " + new SimpleDateFormat("hh:mm:ss aa").format(c.getTime()));

		// Setting a specific date, month is 0-base e.g., 0 for January.
		c.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
		System.out.println("The set day is: " + new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));

		// Printing also the day of the week and month of the set day
		System.out.println("The set day is: " + new SimpleDateFormat("EE MMM dd/MM/yyyy").format(c.getTime()));

		// Printing just the day of the week
		System.out.println("The day of the week was: " + new SimpleDateFormat("EEEE").format(c.getTime()));

		// Printing just the month
		System.out.println("The month was: " + new SimpleDateFormat("MMMM").format(c.getTime()));
	}
	
	private void workingWithDates() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Calendar date1 = Calendar.getInstance();
			date1.setTime(sdf.parse("14/07/2015"));

			Calendar today = Calendar.getInstance();
			//today.setTime(sdf.parse("14/07/2016"));
			
			// There is no easy way to get the distance in between the dates by using Calendar
			long diff = today.getTimeInMillis() - date1.getTimeInMillis();
			System.out.println("Days in between " + sdf.format(date1.getTime()) + " and " + sdf.format(today.getTime()) + ": " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UsingCalendar().Run();
	}
}
