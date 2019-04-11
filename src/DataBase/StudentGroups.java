package DataBase;

import java.util.ArrayList;
import java.util.List;

import School.StudentGroup;

public final class StudentGroups {

	private static final List<StudentGroup> LIST = new ArrayList<>();;

	public static void add(StudentGroup p) {
		LIST.add(p);
	}

	public static List<StudentGroup> getLIST() {
		return LIST;
	}

	public static void clear() {
		LIST.clear();
	}

}
