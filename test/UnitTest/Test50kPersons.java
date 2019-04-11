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

public class Test50kPersons {
	static final Random RANDOM = new Random();
	static final List<Student> STUDENTS_DB;
	static final List<Teacher> TEACHERS_DB;
	static final List<Person> PERSONS_DB;
	static final List<StudentGroup> STUDENTGROUPS_DB;
	static final List<Department> DEPARTMENTS_DB;
	static final List<Subject> SUBJECTS_DB;
	static final int STUDENT_AMOUNT = 500000;
	static final int TEACHER_AMOUNT = 5000;
	static final int GROUP_AMOUNT = 10000;
	static final int DEPARTMENT_AMOUNT = 10;
	static final int SUBJECT_AMOUNT = 10;
	static long start = System.currentTimeMillis();
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
		Persons.showDuplicates();
		System.out.println("Person amount: " + PERSONS_DB.size() + " without duplicates ( "
				+ (STUDENT_AMOUNT + TEACHER_AMOUNT - PERSONS_DB.size()) + " peoples with same PESEL are duplicates)");
		System.out.println((System.currentTimeMillis() - start) / 1000 + "seconds");
	}
}
