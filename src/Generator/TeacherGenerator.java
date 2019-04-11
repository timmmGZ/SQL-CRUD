package Generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import School.Teacher;

public class TeacherGenerator implements GeneratorInterface {

	@SuppressWarnings("deprecation")
	public static Teacher CreateTeacher() {
		Date bday = DateGenerator.birthdate(), hday = DateGenerator.hiredate();
		while (hday.getYear() - bday.getYear() < 18)
			hday = DateGenerator.hiredate();
		String Surname = FOR_NAME[RANDOM.nextInt(FOR_NAME.length)];
		int i = RANDOM.nextInt(FOR_NAME.length - 1);
		String firstName = (i % 3 == 0) ? (FOR_NAME[i] + FOR_NAME[i + 1].toLowerCase()) : FOR_NAME[i];
		return new Teacher(DegreeGenerator.random(), hday, PESELGenerator.generate(bday), Surname, firstName, bday);
	}

	public static List<Teacher> CreateTeacher(int number) {
		if (number <= 0)
			throw new IllegalArgumentException();
		List<Teacher> l = new ArrayList<>();
		for (int i = 0; i < number; i++)
			l.add(CreateTeacher());
		return l;
	}
}
