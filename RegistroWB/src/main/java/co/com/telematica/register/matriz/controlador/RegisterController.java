package co.com.telematica.register.matriz.controlador;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.matriz.modelo.RegisterModelo;

@ManagedBean
@SessionScoped
public class RegisterController {

	private Register register;
	private UploadedFile uploadedFile;
	private List<Register> listaRegistros;

	public RegisterController() {
		RegisterModelo modelo = RegisterModelo.getInstance();

		register = new Register();
		try {
			listaRegistros = modelo.encontrarRegistros();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void guardarFile() throws IOException {
		InputStream input = uploadedFile.getInputstream();

		Path folder = Paths.get("/path/to/uploads");
		String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());
		String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
		Path file = Files.createTempFile(folder, filename + "-", "." + extension);
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public List<Register> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(List<Register> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
