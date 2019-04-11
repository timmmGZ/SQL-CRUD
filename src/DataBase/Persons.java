package DataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import School.Person;

public final class Persons {

	private static final List<Person> LIST = new ArrayList<>();;
	private static Map<Person, List<Person>> m;

	public static void add(Person p) {
		LIST.add(p);
	}

	public static List<Person> getLIST() {
		m = LIST.stream().collect(Collectors.groupingBy(e -> e));
		LIST.clear();
		LIST.addAll(m.keySet());
		System.out.println("Sorting persons...");
		Collections.sort(LIST);
		return LIST;
	}

	public static void showDuplicates() {
		m.values().stream().filter(e -> e.size() > 1).forEach(System.out::println);
	}

}
