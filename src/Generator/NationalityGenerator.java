package Generator;


import School.Nationality;

public class NationalityGenerator implements GeneratorInterface {
	private static final Nationality[] VALUES = Nationality.values();

	public static Nationality random() {
		return VALUES[RANDOM.nextInt(VALUES.length)];
	}
}
