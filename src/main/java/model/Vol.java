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
	
	
//	@Transient
////	private List<Escale> escales=new ArrayList <>();
	
}
