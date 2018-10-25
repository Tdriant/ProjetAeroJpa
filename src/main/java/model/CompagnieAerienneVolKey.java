package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompagnieAerienneVolKey implements Serializable{
	// attributs
	@ManyToOne
	@JoinColumn(name = "compagnie_aerienne_id")
	private CompagnieAerienne compagnieAerienne;
	@ManyToOne
	@JoinColumn(name = "vol_id")
	private Vol vol;

	// contructeurs
	public CompagnieAerienneVolKey() {
	}
	
	public CompagnieAerienneVolKey(CompagnieAerienne compagnieAerienne, Vol vol) {
		this.compagnieAerienne = compagnieAerienne;
		this.vol = vol;
	}

	
}
