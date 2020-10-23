package eu.hem.euler.project.solution;

import java.util.Calendar;

public class P19Sundays {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(1901, 0, 1);
		Calendar end = Calendar.getInstance();
		end.set(2000, 11, 31);

		int count = 0;
		while (cal.before(end)) {
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
			cal.add(Calendar.MONTH, 1);
		}
		System.out.println(count);
	}

}
