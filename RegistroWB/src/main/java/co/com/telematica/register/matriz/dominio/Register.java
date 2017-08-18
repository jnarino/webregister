package co.com.telematica.register.matriz.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "REGISTER")
public class Register implements Serializable {

	private static final long serialVersionUID = 1L;

	// register_id|file_name|file_size|file_modify|owner|creation_date

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "register_id")
	private Long id;

	@Column(name = "file_name", length = 50, nullable = true)
	private String fileName;

	@Column(name = "file_size", length = 50, nullable = true)
	private String fileSize;

	@Column(name = "file_modify", length = 50, nullable = true)
	private String fileModify;

	@Column(name = "owner", length = 50, nullable = true)
	private String owner;

	@Column(name = "creation_date", length = 50, nullable = true)
	private String creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileModify() {
		return fileModify;
	}

	public void setFileModify(String fileModify) {
		this.fileModify = fileModify;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
