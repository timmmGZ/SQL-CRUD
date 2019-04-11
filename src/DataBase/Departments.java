package DataBase;

import java.util.ArrayList;
import java.util.List;

import School.Department;

public final class Departments {
	private static final List<Department> LIST = new ArrayList<>();;

	public static void add(Department p) {
		LIST.add(p);
	}

	public static List<Department> getLIST() {
		return LIST;
	}

	public static void clearList() {
		LIST.clear();
	}

}
