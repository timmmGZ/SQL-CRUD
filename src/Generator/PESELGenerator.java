package Generator;

import java.util.Calendar;
import java.util.Date;

public class PESELGenerator implements GeneratorInterface {
	private static final int[] FORCHECK = { 1, 3, 7, 9, 1, 3, 7, 9, 1, 3 };
	private static Calendar calendar = Calendar.getInstance();

	public static String generate() {
		return generate(datePart());
	}


	public static String generate(Date bday) {
		calendar.setTime(bday);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return generate(YYMMDD(year, month, day));
	}

	private static String generate(String datePart) {
		String yyyx = YYYX();
		return datePart + yyyx + controlDigit(datePart + yyyx);
	}

	private static String YYMMDD(int year, int month, int day) {
		int monthC = 0;
		int century = year / 100;
		switch (century) {
		case 18:
			monthC = month + 80;
			break;
		case 19:
			monthC = month;
			break;
		case 20:
			monthC = month + 20;
			break;
		case 21:
			monthC = month + 40;
			break;
		case 22:
			monthC = month + 60;
			break;
		}
		return String.format("%02d%02d%02d", year % 100, monthC + 1, day);
	}

	private static String datePart() {
		calendar.setTime(DateGenerator.birthdate());
		return YYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
	}

	private static String YYYX() {
		int value = RANDOM.nextInt(10000);
		return String.format("%04d", value);
	}

	private static int controlDigit(String withoutCD) {
		int sum = 0;
		for (int i = 0; i < FORCHECK.length; i++) {
			int digit = withoutCD.charAt(i) - ZERO;
			sum += FORCHECK[i] * digit;
		}
		return (10 - sum % 10) % 10;
	}

}
