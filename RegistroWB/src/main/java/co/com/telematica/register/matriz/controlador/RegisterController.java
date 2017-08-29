package co.com.telematica.register.matriz.controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import co.com.telematica.register.matriz.dominio.Register;
import co.com.telematica.register.matriz.modelo.RegisterModelo;

@ManagedBean
@SessionScoped
public class RegisterController {

	private Register register;
	public UploadedFile uploadedFile;
	private List<Register> listaRegistros;
	private String routeFile;

	public RegisterController() {
		RegisterModelo modelo = RegisterModelo.getInstance();

		register = new Register();
		try {
			listaRegistros = modelo.encontrarRegistros();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void guardarFile(FileUploadEvent event) throws IOException {

		UploadedFile file = event.getFile();
		System.out.println(file.getFileName());
		InputStream input = uploadedFile.getInputstream();

		Path folder = Paths.get("C:/Users/JuanDavidNarinoTapia/Documents/Eafit/Telematica");
		String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());
		String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
		Path filea = Files.createTempFile(folder, filename + "-", "." + extension);
	}

	public void upload() throws IOException {

		System.out.println(
				"Nombre de archivo:: " + uploadedFile.getFileName() + " :: tamano :: " + uploadedFile.getSize());

		System.out.println("***************");
		File f = new File(uploadedFile.getFileName());

		System.out.println("paso por el new file:" + f.getName());

		String filename = FilenameUtils.getName(uploadedFile.getFileName());
		System.out.println("EL nombre del archvo es:" + f.getName());

		InputStream input = (InputStream) uploadedFile.getInputstream();

		System.out.println(RegisterController.class.getClassLoader().getResource("").getPath());
		OutputStream output = new FileOutputStream(new File("/home/user1/proyecto/juan/in", filename));
		// OutputStream output = new FileOutputStream(new File("/", filename));
		routeFile = "/resources/gfx/" + filename;
		try {
			IOUtils.copy(input, output);
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
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

	public String getRouteFile() {
		return routeFile;
	}

	public void setRouteFile(String routeFile) {
		this.routeFile = routeFile;
	}

}
