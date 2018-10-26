package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 1, allocationSize = 10)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=10)
public abstract class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
	private Integer id;
	@Column(name = "client_nom", length = 50)
	private String nom;
	@Column(name = "client_NumTelephone", length = 10)
	private Integer numeroTelephone;
	@Column(name = "client_NumFax", length = 50)
	private Integer numeroFax;
	@Column(name = "client_email", length = 50)
	private String email;
	@Version
	private int version;

	public  Client() {
	}

	public Client(String nom, Integer numeroTelephone, Integer numeroFax, String email) {
		super();
		this.nom = nom;
		this.numeroTelephone = numeroTelephone;
		this.numeroFax = numeroFax;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(Integer numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public Integer getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
