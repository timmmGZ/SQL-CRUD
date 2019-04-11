package DataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import School.Teacher;

public final class Teachers {
	private static final List<Teacher> LIST = new ArrayList<>();;

	public static void add(Teacher p) {
		LIST.add(p);
	}

	public static List<Teacher> getLIST() {
		Set<Teacher> s = new HashSet<>(LIST);
		LIST.clear();
		LIST.addAll(s);		
		System.out.println("Sorting tearchers...");
		Collections.sort(LIST);
		return LIST;
	}

}
