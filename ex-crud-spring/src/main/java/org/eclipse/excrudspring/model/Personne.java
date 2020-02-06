package org.eclipse.excrudspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Personne {
	@Id
	@GeneratedValue
	private Long num;
	@Size(min = 2, message = "Le nom doit contenir entre 2 et 15 caractères.") 
	@NotEmpty(message = "Le champ nom est obligatoire")
	private String nom;
	@Size(min = 2, message = "Le prénom doit contenir entre 2 et 15 caractères.") 
	@NotEmpty(message = "Le champ prénom est obligatoire")
	private String prenom;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
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

	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
