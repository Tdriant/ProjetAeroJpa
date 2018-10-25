package model;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 50, allocationSize = 1)
public class Vol {
	
	@Id
	@Column(name="id_vol")
	@GeneratedValue(generator="seqVol", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="date_depart_vol")
	@Temporal(TemporalType.DATE)
	private Date DateDepart;
	@Column(name="date_arrivee_vol")
	@Temporal(TemporalType.DATE)
	private Date DateArrivee;
	@Column(name="heure_depart_vol")
	@Temporal(TemporalType.TIMESTAMP)
	private static Date heureDepart;
	@Column(name="heure_arrivee_vol")
	@Temporal(TemporalType.TIMESTAMP)
	private static Date heureArrivee;
	@Version

	private Integer version;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getDateDepart() {
		return DateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		DateDepart = dateDepart;
	}
	public Date getDateArrivee() {
		return DateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		DateArrivee = dateArrivee;
	}
	public static Date getHeureDepart() {
		return heureDepart;
	}
	public static void setHeureDepart(Date heureDepart) {
		Vol.heureDepart = heureDepart;
	}
	public static Date getHeureArrivee() {
		return heureArrivee;
	}
	public static void setHeureArrivee(Date heureArrivee) {
		Vol.heureArrivee = heureArrivee;
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
		Vol other = (Vol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Vol() {
		super();
	}
	public Vol(Date dateDepart, Date dateArrivee) {
		super();
		DateDepart = dateDepart;
		DateArrivee = dateArrivee;
	}
	
	
//	@Transient
////	private List<Escale> escales=new ArrayList <>();
	
}
