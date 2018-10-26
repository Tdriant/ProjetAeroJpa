package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compagnie_aerienne_vol")
public class CompagnieAerienneVol {
	// attributs
	@EmbeddedId
	private CompagnieAerienneVolKey key;

	// contructeurs
	public CompagnieAerienneVol() {

	}

	public CompagnieAerienneVol(CompagnieAerienneVolKey key) {
		this.key = key;
	}

	// getters
	public CompagnieAerienneVolKey getKey() {
		return key;
	}

	// setters
	public void setKey(CompagnieAerienneVolKey key) {
		this.key = key;
	}

	// methodes
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompagnieAerienneVol other = (CompagnieAerienneVol) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
