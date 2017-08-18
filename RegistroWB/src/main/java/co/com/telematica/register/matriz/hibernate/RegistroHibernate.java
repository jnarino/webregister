package co.com.telematica.register.matriz.hibernate;

public class RegistroHibernate {

	private static RegistroHibernate instance;

	private RegistroHibernate() {
	}

	public static RegistroHibernate getInstance() {
		if (instance == null) {
			instance = new RegistroHibernate();
		}
		return instance;
	}

}
