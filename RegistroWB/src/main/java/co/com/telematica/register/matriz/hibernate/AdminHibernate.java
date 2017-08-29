package co.com.telematica.register.matriz.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.session.dominio.Usuarios;
import co.com.telenatica.commons.hibernate.AnnotationsFactory;

public class AdminHibernate {

	private static final Logger log = LogManager.getLogger(AdminHibernate.class);

	private static AdminHibernate instance;

	private AdminHibernate() {
	}

	public static AdminHibernate getInstance() {
		if (instance == null) {
			instance = new AdminHibernate();
		}
		return instance;
	}

	public List<Usuarios> encontrarUsuarios() throws Exception {
		List<Usuarios> listaUsuarios = null;
		try {
			Session session = null;

			session = AnnotationsFactory.getInstance().getSession();

			session.beginTransaction();
			Criteria criterios = session.createCriteria(Usuarios.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criterios.addOrder(Order.desc("id"));
			listaUsuarios = criterios.list();
			session.close();
			return listaUsuarios;
		} catch (Exception e) {
			log.error("Problema en conexión a base de datos", e);
		}
		return listaUsuarios;

	}

}
