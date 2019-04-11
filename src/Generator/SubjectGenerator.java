package Generator;

import java.util.ArrayList;
import java.util.List;

import School.Department;
import School.Student;
import School.Subject;
import School.Teacher;

public class SubjectGenerator implements GeneratorInterface {

	public static List<Subject> CreateSubject(int number, List<Department> d, List<Student> s) {
		if (number <= 0)
			throw new IllegalArgumentException();
		List<Subject> subjectL = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			System.out.println("Initializing subjects..." + (i + 1 )+ "/" + number);
			List<Student> sList = new ArrayList<>();
			Department dept = d.get(RANDOM.nextInt(d.size()));
			Teacher teacher = dept.getTeachers().get(RANDOM.nextInt(dept.getTeachers().size()));
			int propabilty = RANDOM.nextInt(3);
			switch (propabilty) {
			case 0:
				for (int j = 0; j < s.size(); j++)
					if (RANDOM.nextInt(10) >= 3)
						sList.add(s.get(j));
				break;
			case 1:
				for (int j = 0; j < s.size(); j++)
					if (RANDOM.nextInt(10) % 3 == 0)
						sList.add(s.get(j));
				break;
			case 2:
				for (int j = 0; j < s.size(); j++)
					if (RANDOM.nextInt(10) % 4 == 0)
						sList.add(s.get(j));
				break;
			}
			subjectL.add(new Subject(SUBJECT_NAME[i], dept, teacher, sList));
		}
		return subjectL;
	}

}
