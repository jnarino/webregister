package co.com.telematica.register.session.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	// users_id | first_name | middle_name | last_name | owner_id | username |
	// password | creation_date

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "users_id")
	private Long id;

	@Column(name = "first_name", length = 50, nullable = true)
	private String firstName;

	@Column(name = "middle_name", length = 50, nullable = true)
	private String middelName;

	@Column(name = "last_name", length = 50, nullable = true)
	private String lastName;

	@Column(name = "owner_id", length = 50, nullable = true)
	private String ownerId;

	@Column(name = "username", length = 50, nullable = true)
	private String username;

	@Column(name = "password", length = 50, nullable = true)
	private String password;

	@Column(name = "creation_date")
	private String creatioDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddelName() {
		return middelName;
	}

	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatioDate() {
		return creatioDate;
	}

	public void setCreatioDate(String creatioDate) {
		this.creatioDate = creatioDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
