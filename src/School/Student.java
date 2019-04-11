package School;

import java.util.Date;

import DataBase.Students;

public class Student extends Person {

	private final String studentBookNo;

	public Student(String sb, String p, String s, String f, Date b) {
		super(p, s, f, b);
		studentBookNo = sb;
		Students.add(this);
	}

	public String getStudentBookNo() {
		return studentBookNo;
	}

	public String toString() {
		return "BookNo: " + String.format("%-7s", studentBookNo) + ", " + super.toString();
	}
}
