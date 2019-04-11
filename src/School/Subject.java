package School;

import java.util.List;

import DataBase.Subjects;

public final class Subject {
	private String name;
	private Department supervisingDepartment;
	private Teacher lecturer;
	private List<Student> attendingStudents;

	public Subject(String n, Department sd, Teacher l, List<Student> as) {
		name = n;
		supervisingDepartment = sd;
		lecturer = l;
		attendingStudents = as;
		Subjects.add(this);
	}

	public Department getSupervisingDepartment() {
		return supervisingDepartment;
	}

	public Teacher getLecturer() {
		return lecturer;
	}

	public List<Student> getAttendingStudents() {
		return attendingStudents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendingStudents == null) ? 0 : attendingStudents.hashCode());
		result = prime * result + ((lecturer == null) ? 0 : lecturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((supervisingDepartment == null) ? 0 : supervisingDepartment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (attendingStudents == null) {
			if (other.attendingStudents != null)
				return false;
		} else if (!attendingStudents.equals(other.attendingStudents))
			return false;
		if (lecturer == null) {
			if (other.lecturer != null)
				return false;
		} else if (!lecturer.equals(other.lecturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (supervisingDepartment == null) {
			if (other.supervisingDepartment != null)
				return false;
		} else if (!supervisingDepartment.equals(other.supervisingDepartment))
			return false;
		return true;
	}

	public String toString() {
		return "Subejct: " + name + ", department:" + supervisingDepartment + ", lecturer: "
				+ String.format("%-10s", (lecturer.getAcademicDegree().getShortName() + " " + lecturer.getSurname()))
				+ ", student amount:" + attendingStudents.size();
	}

}
