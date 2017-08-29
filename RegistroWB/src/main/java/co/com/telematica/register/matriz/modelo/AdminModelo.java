package co.com.telematica.register.matriz.modelo;

import java.util.List;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.matriz.hibernate.AdminHibernate;
import co.com.telematica.register.matriz.hibernate.RegistroHibernate;
import co.com.telematica.register.session.dominio.Usuarios;

public class AdminModelo {

	private static AdminModelo instance;

	public static AdminModelo getInstance() {
		if (instance == null) {
			instance = new AdminModelo();
		}
		return instance;
	}

	public List<Usuarios> encontrarUsuarios() throws Exception {
		List<Usuarios> listaUsuarios;
		AdminHibernate adminHibernate = AdminHibernate.getInstance();
		listaUsuarios = adminHibernate.encontrarUsuarios();

		return listaUsuarios;
	}

}
