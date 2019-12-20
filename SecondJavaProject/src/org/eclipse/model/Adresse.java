package org.eclipse.model;

public class Adresse {
	private String rue;
	private String codePostal;
	private String ville;

	public Adresse(String rue, String codePostal, String ville) {
		this.rue = rue;
		setCodePostal(codePostal);
		this.ville = ville;
	}

	public Adresse() {
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		if (codePostal.length() == 5)
			this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	

}
