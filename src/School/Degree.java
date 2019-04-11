package School;

public enum Degree {
	Bachelor("BSc."), Master("MSc."), Doctor("Dr."), Professor("phD.");
	private final String shortName;

	private Degree(String s) {
		shortName = s;
	}

	public String getShortName() {
		return shortName;
	}
}
