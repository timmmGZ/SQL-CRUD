package Generator;

import java.util.ArrayList;
import java.util.List;

import DataBase.Departments;
import School.Department;
import School.Teacher;

public class DepartmentGenerator2 implements GeneratorInterface {

	public static List<Department> CreateDepartmentAndAssignTeachers(int numberOfDept, List<Teacher> teacher_DB) {
		if (numberOfDept <= 0)
			throw new IllegalArgumentException();
		int numOfAssignedTeachers = 0;
		List<Department> dL = new ArrayList<>();
		for (int i = 0; i < numberOfDept; i++) {
			List<Teacher> tList = new ArrayList<>();
			int teacherNumOfCurrentDept = teacher_DB.size() / numberOfDept - 3 + RANDOM.nextInt(7);
			if (numOfAssignedTeachers + teacherNumOfCurrentDept >= teacher_DB.size()) {
				System.err.println(
						"#ERROR# Inlitialize departments again, all teachers already assign, rest departments won't have teachers to assign");
				Departments.clearList();
				return CreateDepartmentAndAssignTeachers(numberOfDept, teacher_DB);
			} else {
				System.out.println("Initializing departments..." + (i + 1) + "/" + numberOfDept);
				if (i == numberOfDept - 1)
					teacherNumOfCurrentDept = teacher_DB.size() - numOfAssignedTeachers;
				for (int j = numOfAssignedTeachers; j < numOfAssignedTeachers + teacherNumOfCurrentDept; j++)
					tList.add(teacher_DB.get(j));
				dL.add(new Department(DEPARTMENT_NAME[i], tList));
				numOfAssignedTeachers += teacherNumOfCurrentDept;
			}
		}
		return dL;
	}
}
