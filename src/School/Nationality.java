package School;

import java.util.Locale;

public enum Nationality {
	Polish("pl"), Ukrainian("uk"), Belarussian("bl"), Slovak("sl"), Lithuanian("lh"), Latvian("lt"), British(
			"br"), Indian("in"), Chinese("zh"), Vietnamese("vn");
	private final String forLocale;

	private Nationality(String s) {
		forLocale = s;
	}

	public Locale getLocale() {
		return new Locale(forLocale);
	}
}
