package School;

import java.util.List;

import DataBase.Departments;

public class Department {
	private final String name;
	private final List<Teacher> teachers;

	public Department(String n, List<Teacher> t) {
		name = n;
		teachers = t;
		Departments.add(this);
	}

	public String getName() {
		return name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teachers == null) ? 0 : teachers.hashCode());
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
		Department other = (Department) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teachers == null) {
			if (other.teachers != null)
				return false;
		} else if (!teachers.equals(other.teachers))
			return false;
		return true;
	}

	public String toString() {
		return String.format("%-10s", name) + ", number of teachers: " + String.format("%-2s", teachers.size());
	}
}
