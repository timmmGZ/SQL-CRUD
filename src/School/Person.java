package School;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import DataBase.Persons;
import Generator.NationalityGenerator;

public abstract class Person implements Comparable<Person> {
	public final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private String PESEL;
	private final String surname;
	private final String firstName;
	private final Date birthDay;
	private final Nationality Nationality = NationalityGenerator.random();
	private static final Collator C_PL = Collator.getInstance(new Locale("pl"));

	protected Person(String p, String s, String f, Date b) {
		PESEL = p;
		surname = s;
		firstName = f;
		birthDay = b;
		Persons.add(this);
	}

	public String getPESEL() {
		return PESEL;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String s) {
		PESEL = s;
	}

	public String getFirstName() {
		return firstName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	@Override
	public int compareTo(Person p) {
		int r = C_PL.compare(surname, p.surname);
		if (r != 0)
			return r;
		return C_PL.compare(firstName, p.firstName);
	}

	@Override
	public int hashCode() {
		return PESEL.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (PESEL == null) {
			if (other.PESEL != null)
				return false;
		} else if (!PESEL.equals(other.PESEL))
			return false;
		return true;
	}

	public String toString() {
		return String.format("PESEL: %-7s, name: %-10s%-5s", getPESEL(), firstName, surname) + ", birthday: "
				+ FORMAT.format(getBirthDay()) + ", nationality: " +String.format("%-11s", Nationality) ;
	}
}
