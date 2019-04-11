package Generator;

import java.util.ArrayList;
import java.util.List;

import DataBase.StudentGroups;
import School.Student;
import School.StudentGroup;

public class StudentGroupGenerator implements GeneratorInterface {

	public static List<StudentGroup> CreateStudentGroupAndAssign(int number, List<Student> s) {
		if (number <= 0)
			throw new IllegalArgumentException();
		int prev = 0, standardSize = s.size() / number;
		List<StudentGroup> sGL = new ArrayList<>();
		for (int i = 1; i < number + 1; i++) {
			List<Student> sList = new ArrayList<>();
			int studentNumOfGroup = standardSize - 3 + RANDOM.nextInt(7);
			if (prev + studentNumOfGroup - s.size() >= 0) { // in case remaining group don't have students to assign
				System.err.println(
						"#ERROR# Inlitialize groups again, all students already assign, rest groups won't have student to assign");
				StudentGroups.clear();
				return CreateStudentGroupAndAssign(number, s);
			} else {
				System.out.println("Inlitializing groups..." + i + "/" + number);
				if (i == number)
					studentNumOfGroup = s.size() - prev;
				for (int j = prev; j < prev + studentNumOfGroup; j++)
					sList.add(s.get(j));
				sGL.add(new StudentGroup("G" + i, sList));
				prev += studentNumOfGroup;
			}
		}
		return sGL;
	}
}
