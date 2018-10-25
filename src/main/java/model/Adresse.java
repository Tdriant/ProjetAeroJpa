package model;

public class Adresse {
	// attributs
	private Integer id;
	private Integer numero;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
//	private Client client
//	private Passager passager

	// constructeurs
	public Adresse() {
	}

	public Adresse(Integer id, Integer numero, String rue, String codePostal, String ville, String pays) {
		this(numero, rue, codePostal, ville, pays);
		this.id = id;

	}

	public Adresse(Integer numero, String rue, String codePostal, String ville, String pays) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	// getters
	public Integer getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
	}

	// setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	// methodes
}
