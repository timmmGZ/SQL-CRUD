package School;

import java.util.List;

import DataBase.StudentGroups;

public class StudentGroup {
	private final String name;
	private final List<Student> students;

	public StudentGroup(String n, List<Student> s) {
		name = n;
		students = s;
		StudentGroups.add(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		StudentGroup other = (StudentGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String toString() {
		return "Group name: " + name+", number of Students: "+students.size();
	}
}
