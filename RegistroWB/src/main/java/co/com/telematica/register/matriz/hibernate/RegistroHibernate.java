package co.com.telematica.register.matriz.hibernate;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.com.telematica.register.matriz.dominio.Register;

public class RegistroHibernate {

	private static final Logger log = LogManager.getLogger(RegistroHibernate.class);

	private static RegistroHibernate instance;

	private RegistroHibernate() {
	}

	public static RegistroHibernate getInstance() {
		if (instance == null) {
			instance = new RegistroHibernate();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Register> encontrarRegistro() throws Exception {
		List<Register> listaRegister = null;
		try {

			// SessionFactory fabrica = AnnotationsFactory.getSessionFactory();
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criterios = session.createCriteria(Register.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			listaRegister = criterios.list();
			session.close();

		} catch (Exception e) {
			log.error("Problema en conexión a base de datos", e);
		}
		return listaRegister;

	}

}
