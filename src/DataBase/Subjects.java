package DataBase;

import java.util.ArrayList;
import java.util.List;

import School.Subject;

public final class Subjects {

	private static final List<Subject> LIST = new ArrayList<>();

	public static void add(Subject p) {
		LIST.add(p);
	}

	public static List<Subject> getLIST() {
		return LIST;
	}

}
