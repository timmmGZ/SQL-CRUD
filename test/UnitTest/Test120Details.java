package UnitTest;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import DataBase.Departments;
import DataBase.Persons;
import DataBase.StudentGroups;
import DataBase.Students;
import DataBase.Subjects;
import DataBase.Teachers;
import Generator.SchoolGenerator;
import School.Department;
import School.Person;
import School.Student;
import School.StudentGroup;
import School.Subject;
import School.Teacher;

public class Test120Details {
	static final Random RANDOM = new Random();
	static final List<Student> STUDENTS_DB;
	static final List<Teacher> TEACHERS_DB;
	static final List<Person> PERSONS_DB;
	static final List<StudentGroup> STUDENTGROUPS_DB;
	static final List<Department> DEPARTMENTS_DB;
	static final List<Subject> SUBJECTS_DB;
	static final int STUDENT_AMOUNT = 120;
	static final int TEACHER_AMOUNT = 20;
	static final int GROUP_AMOUNT = 10;
	static final int DEPARTMENT_AMOUNT = 4;
	static final int SUBJECT_AMOUNT = 4;
	static {
		new SchoolGenerator(STUDENT_AMOUNT, TEACHER_AMOUNT, GROUP_AMOUNT, DEPARTMENT_AMOUNT, SUBJECT_AMOUNT);
		TEACHERS_DB = Teachers.getLIST();
		STUDENTS_DB = Students.getLIST();
		PERSONS_DB = Persons.getLIST();
		STUDENTGROUPS_DB = StudentGroups.getLIST();
		DEPARTMENTS_DB = Departments.getLIST();
		SUBJECTS_DB = Subjects.getLIST();
	}

	@Test
	public void StudentsAreAssignToSubjects() {
		List<Student> randomSubjectStudentList = SUBJECTS_DB.get(RANDOM.nextInt(SUBJECTS_DB.size()))
				.getAttendingStudents();
		Student random = randomSubjectStudentList.get(RANDOM.nextInt(randomSubjectStudentList.size()));
		Assert.assertTrue(STUDENTS_DB.contains(random));
	}

	@Test
	public void StudentsAreAssignToGroups() {
		List<Student> randomGroupStudentList = STUDENTGROUPS_DB.get(RANDOM.nextInt(STUDENTGROUPS_DB.size()))
				.getStudents();
		Student random = randomGroupStudentList.get(RANDOM.nextInt(randomGroupStudentList.size()));
		Assert.assertTrue(STUDENTS_DB.contains(random));
	}

	@Test
	public void TeachersAreAssignToSubjects() {
		Subject randomSubject = SUBJECTS_DB.get(RANDOM.nextInt(SUBJECTS_DB.size()));
		Teacher itsTeacher = randomSubject.getLecturer();
		Department itsDept = randomSubject.getSupervisingDepartment();
		List<Teacher> itsDeptsTeachers = itsDept.getTeachers();
		Assert.assertTrue(TEACHERS_DB.contains(itsTeacher));
		Assert.assertTrue(DEPARTMENTS_DB.contains(itsDept));
		Assert.assertTrue(itsDeptsTeachers.contains(itsTeacher));
	}

	@Test
	public void Print2() {
		System.out.println("----------------------------------------");
		for (Subject sj : SUBJECTS_DB)
			System.out.println(sj);
		System.out.println("----------------------------------------");
		System.out.println("Total teachers: " + TEACHERS_DB.size());
		for (Department dd : DEPARTMENTS_DB)
			System.out.println(dd);
		System.out.println("----------------------------------------");
		System.out.println("Total students: " + STUDENTS_DB.size());
		for (StudentGroup ss : STUDENTGROUPS_DB)
			System.out.println(ss);
	}

	@Test
	public void Print() {
		System.out.println("*****************************************************************************************");
		System.out.println("***********************************Detail*Mode******************************************");
		System.out.println("****************************************************************************************");

		for (Subject sj : SUBJECTS_DB) {
			System.out.println(sj);
			for (Teacher d : sj.getSupervisingDepartment().getTeachers())
				System.out.println("	" + d);
		}
		System.out.println("----------------------------------------");
		System.out.println("Total teachers: " + TEACHERS_DB.size());
		for (Department dd : DEPARTMENTS_DB) {
			System.out.println(dd);
			for (Teacher d : dd.getTeachers())
				System.out.println("	" + d);
		}
		System.out.println("----------------------------------------");
		System.out.println("Total students: " + STUDENTS_DB.size());
		for (StudentGroup ss : STUDENTGROUPS_DB) {
			System.out.println(ss);
			for (Student s : ss.getStudents())
				System.out.println("	" + s);
		}
		System.out.println("----------------------------------------");
		System.out.println("Persons sorted by surname and then first name");

		for (Student s : STUDENTS_DB)
			System.out.println(s);
		for (Teacher t : TEACHERS_DB)
			System.out.println(t);

	}

}
