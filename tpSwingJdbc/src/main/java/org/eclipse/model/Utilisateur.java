package org.eclipse.model;

public class Utilisateur {
	private int num;
	private String nom;
	private String prenom;
	private String sexe;
	private String type;

	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(int num, String nom, String prenom, String sexe, String type) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
	}
	public Utilisateur(String nom, String prenom, String sexe, String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Utilisateur [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", type=" + type
				+ "]";
	}

}
