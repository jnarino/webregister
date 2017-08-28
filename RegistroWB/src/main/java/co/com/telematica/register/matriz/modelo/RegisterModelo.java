package co.com.telematica.register.matriz.modelo;

import java.util.List;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.matriz.hibernate.RegistroHibernate;

public class RegisterModelo {

	private static RegisterModelo instance;

	public static RegisterModelo getInstance() {
		if (instance == null) {
			instance = new RegisterModelo();
		}
		return instance;
	}

	public List<Register> encontrarRegistros() throws Exception {
		List<Register> listaRegistros;
		RegistroHibernate registroHibernate = RegistroHibernate.getInstance();
		listaRegistros = registroHibernate.encontrarRegistro();

		return listaRegistros;
	}
}
