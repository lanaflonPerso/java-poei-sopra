package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "sports")
public class Sport {
	@Id
	private String nom;
	private String type;

	@ManyToMany(mappedBy = "sports")
	private List<Personne> personnes = new ArrayList<Personne>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public void removePersonne(Personne personne) {
		personnes.remove(personne);
		personne.getSports().remove(this);
	}

	public void addPersonne(Personne personne) {
		personnes.add(personne);
		personne.getSports().add(this);
	}

	@Override
	public String toString() {
		return "Sport [nom=" + nom + ", type=" + type + "]";
	}

}
