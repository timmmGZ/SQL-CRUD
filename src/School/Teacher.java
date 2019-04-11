package School;

import java.util.Date;

import DataBase.Teachers;

public class Teacher extends Person {
	private final Degree academicDegree;
	private final Date hiredate;

	public Teacher(Degree ad, Date h, String p, String s, String f, Date b) {
		super(p, s, f, b);
		academicDegree = ad;
		hiredate = h;
		Teachers.add(this);
	}

	public Date getHiredate() {
		return hiredate;
	}

	public Degree getAcademicDegree() {
		return academicDegree;
	}


	public String toString() {
		return "Degree: " + String.format("%-10s", academicDegree) + ", hiredate: " + FORMAT.format(hiredate) + ", " + super.toString();
	}
}
