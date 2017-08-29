package co.com.telematica.register.session.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.telematica.register.session.dominio.Usuarios;
import co.com.telematica.register.session.model.SessionModel;

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

	private Usuarios usuarios;
	private boolean securityAccess;

	private static final long serialVersionUID = 1L;

	public SessionController() {
		usuarios = new Usuarios();
		securityAccess = false;
	}

	public String iniciarSession() {
		Usuarios usuariosReturn;
		SessionModel sessionModel = new SessionModel();
		String admin = "admin";

		String redireccion = null;

		try {

			usuariosReturn = sessionModel.encontrarUsuario(usuarios);
			if (usuariosReturn != null) {
				String username = usuariosReturn.getUsername();
				if (username.trim() == admin.trim()) {
					securityAccess = true;
					System.out.println("*****************************login admin*************************");
					redireccion = "/protegido/adminpanel?faces-redirect=true";
				} else {
					securityAccess = true;
					System.out.println("*****************************login correcto*************************");
					redireccion = "/protegido/registerList?faces-redirect=true";
				}

			}

		} catch (Exception e) {

		}
		return redireccion;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}
