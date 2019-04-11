package Generator;

import java.util.List;

import School.Department;
import School.Student;
import School.StudentGroup;
import School.Subject;
import School.Teacher;

public class SchoolGenerator {
	static List<Student> students;
	static List<Teacher> teachers;
	static List<StudentGroup> studentGroups;
	static List<Department> departments;
	static List<Subject> subjects;

	public SchoolGenerator(int s, int t, int g, int d, int subject) {
		teachers = TeacherGenerator.CreateTeacher(t);
		students = StudentGenerator.CreateStudent(s);
		studentGroups = StudentGroupGenerator.CreateStudentGroupAndAssign(g, students);
		departments = DepartmentGenerator.CreateDepartmentAndAssignTeachers(d, teachers);
		subjects = SubjectGenerator.CreateSubject(subject, departments, students);
	}
}
