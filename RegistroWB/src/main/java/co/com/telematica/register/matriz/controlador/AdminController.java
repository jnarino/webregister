package co.com.telematica.register.matriz.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.matriz.modelo.AdminModelo;
import co.com.telematica.register.matriz.modelo.RegisterModelo;
import co.com.telematica.register.session.dominio.Usuarios;

@ManagedBean
@SessionScoped
public class AdminController {

	private Usuarios usuarios;

	private List<Usuarios> listaUsuarios;

	public AdminController() {
		AdminModelo modelo = AdminModelo.getInstance();

		usuarios = new Usuarios();
		try {
			listaUsuarios = modelo.encontrarUsuarios();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	

}
