package co.com.telematica.register.matriz.hibernate;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telenatica.commons.hibernate.AnnotationsFactory;

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

	public List<Register> encontrarRegistro() throws Exception {
		List<Register> listaRegister = null;
		try {
			Session session = null;

			session = AnnotationsFactory.getInstance().getSession();

			session.beginTransaction();
			 Criteria criterios = session.createCriteria(Register.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	            criterios.addOrder(Order.desc("id"));
	            listaRegister = criterios.list();
	            session.close();
	            return listaRegister;
		} catch (Exception e) {
			log.error("Problema en conexión a base de datos", e);
		}
		return listaRegister;

	}

}
