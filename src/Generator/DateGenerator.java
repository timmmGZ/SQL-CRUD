package Generator;

import java.util.Calendar;
import java.util.Date;

public class DateGenerator implements GeneratorInterface {
	static final int YEAR_START;
	static final int YEAR_END;
	private static Calendar calendar = Calendar.getInstance();

	static {
		calendar.setTime(TODAY);
		int currentYear = calendar.get(Calendar.YEAR);
		YEAR_START = currentYear - YEAR_BACK;
		YEAR_END = YEAR_START + YEARS_COUNT;
	}

	public static Date birthdate() {
		int year = YEAR_START + RANDOM.nextInt(YEARS_COUNT);
		int month = MONTH_START + RANDOM.nextInt(MONTHS_IN_YEAR);
		int day = DAY_START + RANDOM.nextInt(DAYS_IN_MONTH);
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	public static Date hiredate() {
		int year = YEAR_START + RANDOM.nextInt(30)+30;
		int month = MONTH_START + RANDOM.nextInt(MONTHS_IN_YEAR);
		int day = DAY_START + RANDOM.nextInt(DAYS_IN_MONTH);
		calendar.set(year, month, day);
		return calendar.getTime();
	}
}
