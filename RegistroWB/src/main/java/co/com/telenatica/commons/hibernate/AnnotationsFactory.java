package co.com.telenatica.commons.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnnotationsFactory {

	private static AnnotationsFactory me;
	private Configuration cfg;
	private SessionFactory sessionFactory;

	private AnnotationsFactory() throws HibernateException {

		// build the config
		cfg = new Configuration().configure();

		sessionFactory = cfg.buildSessionFactory();
	}

	public static synchronized AnnotationsFactory getInstance() throws HibernateException {
		if (me == null) {
			me = new AnnotationsFactory();
		}

		return me;
	}

	public Session getSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		if (!session.isConnected()) {
			this.reconnect();
		}
		return session;
	}

	@SuppressWarnings("deprecation")
	private void reconnect() throws HibernateException {
		this.sessionFactory = cfg.buildSessionFactory();
	}
}
