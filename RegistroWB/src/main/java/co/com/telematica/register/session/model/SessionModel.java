package co.com.telematica.register.session.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.telematica.register.session.dominio.Usuarios;
import co.com.telematica.register.session.hibernate.SessionHibernate;

public class SessionModel {

	private static final Logger log = LogManager.getLogger(SessionModel.class);

	public Usuarios encontrarUsuario(Usuarios usuarios) throws Exception {
		Usuarios usuariosReturn = null;
		try {
			boolean accessSecurity;
			SessionHibernate sessionHibernate = SessionHibernate.getInstance();
			usuariosReturn = sessionHibernate.encontrarUsuario(usuarios);

		} catch (Exception e) {
			System.out.println("Error encontrando usuario" + e);
		}
		return usuariosReturn;
	}

}
