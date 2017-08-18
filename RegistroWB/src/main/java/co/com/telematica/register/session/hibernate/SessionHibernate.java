package co.com.telematica.register.session.hibernate;

import java.io.Serializable;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import co.com.telematica.register.session.dominio.Usuarios;

public class SessionHibernate implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LogManager.getLogger(SessionHibernate.class);

	private static SessionHibernate instance;

	private SessionHibernate() {

	}

	public static SessionHibernate getInstance() {
		if (instance == null) {
			instance = new SessionHibernate();
		}
		return instance;
	}

	public Usuarios encontrarUsuario(Usuarios usuarios) throws Exception {
		Usuarios usuarioReturn = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuarios.class);
			criteria.add(Restrictions.eq("username", usuarios.getUsername()));
			criteria.add(Restrictions.eq("password", usuarios.getPassword()));
			usuarioReturn = (Usuarios) criteria.uniqueResult();
			session.close();
		} catch (Exception e) {
			log.error("Problema en conexi�n a base de datos", e);
		}
		return usuarioReturn;
	}

}
