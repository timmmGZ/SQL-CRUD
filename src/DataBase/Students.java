package DataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import School.Student;

public final class Students {
	private static final List<Student> LIST = new ArrayList<>();;

	public static void add(Student p) {
		LIST.add(p);
	}

	public static List<Student> getLIST() {
		Set<Student> s = new HashSet<>(LIST);
		LIST.clear();
		LIST.addAll(s);	
		System.out.println("Sorting students...");
		Collections.sort(LIST);
		return LIST;
	}



}
