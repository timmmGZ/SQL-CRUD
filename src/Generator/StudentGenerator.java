package Generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import School.Student;

public class StudentGenerator implements GeneratorInterface {
	private static int i = 1;

	public static Student CreateStudent() {
		Date bday = DateGenerator.birthdate();
		String bookno = "s" + i++;
		String Surname = FOR_NAME[RANDOM.nextInt(FOR_NAME.length)];
		int i = RANDOM.nextInt(FOR_NAME.length - 1);
		String firstName = (i % 3 == 0) ? (FOR_NAME[i] + FOR_NAME[i + 1].toLowerCase()) : FOR_NAME[i];
		return new Student(bookno, PESELGenerator.generate(bday), Surname, firstName, bday);
	}

	public static List<Student> CreateStudent(int number) {
		List<Student> l = new ArrayList<>();
		if (number <= 0)
			throw new IllegalArgumentException();
		for (int n = 0; n < number; n++) {
			System.out.println("Initializing students..." + i + "/" + number);
			l.add(CreateStudent());
		}
		return l;
	}
}
