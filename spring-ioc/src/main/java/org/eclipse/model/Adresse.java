package org.eclipse.model;

public class Adresse {
	private String rue;
	private String codeP;
	private String ville;

	public Adresse(String rue, String codeP, String ville) {
		this.rue = rue;
		this.codeP = codeP;
		this.ville = ville;
	}

	public String toString() {
		return "Adresse [rue=" + rue + ", codeP=" + codeP + ", ville=" + ville + "]";
	}
}
