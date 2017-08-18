package co.com.telematica.register.session.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.com.telematica.register.session.dominio.Usuarios;
import co.com.telematica.register.session.model.SessionModel;

@Named
@ViewScoped
public class SessionController implements Serializable {

	private Usuarios usuarios;
	private boolean securityAccess;

	private static final long serialVersionUID = 1L;

	public SessionController() {
		usuarios = new Usuarios();
		securityAccess = false;
	}

	public void iniciarSession() {
		Usuarios usuariosReturn;
		SessionModel sessionModel = new SessionModel();
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

		try {

			usuariosReturn = sessionModel.encontrarUsuario(usuarios);
			if (usuariosReturn != null) {
				securityAccess = true;
				System.out.println("CONECXION EXITOSA");
				context.redirect("/RegistroWB/protegido/NewFile.xhtml");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}
