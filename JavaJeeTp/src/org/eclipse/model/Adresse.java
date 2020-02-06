package org.eclipse.model;

public class Adresse {
	private int id;
	private String rue;
	private String ville;
	private String codePostal;
	private Personne personne;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String ville, String codePostal, Personne personne) {
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.personne = personne;
	}

	public Adresse(int id, String rue, String ville, String codePostal, Personne personne) {
		this.id = id;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.personne = personne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + ", personne="
				+ personne + "]";
	}

}
