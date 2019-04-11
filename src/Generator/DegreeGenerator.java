package Generator;


import School.Degree;

public class DegreeGenerator implements GeneratorInterface {
	private static final Degree[] VALUES = Degree.values();

	public static Degree random() {
		return VALUES[RANDOM.nextInt(VALUES.length)];
	}
}
