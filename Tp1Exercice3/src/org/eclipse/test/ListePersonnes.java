package org.eclipse.test;

import java.util.Arrays;

public class ListePersonnes {
	private Personne[] personnes;

	public ListePersonnes(Personne[] personnes) {
		super();
		this.personnes = personnes;
	}

	public ListePersonnes() {
		super();
	}

	public Personne[] getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne[] personnes) {
		if (personnes.length < 11)
			this.personnes = personnes;
	}

	public Personne findByNom(String s) {
		for (Personne personne : personnes) {
			if (personne.getNom().equals(s)) {
				return personne;
			}
		}
		return null;
	}

	public boolean findByCodePostal(String cp) {
		for (Personne personne : personnes) {
			for (Adresse adresse : personne.getAdresses()) {
				if (adresse.getCodePostal().equals(cp)) {
					return true;
				}
			}
		}
		return false;
	}

	public int countPersonneVille(String ville) {
		int count = 0;
		int i;
		for (i=0; i<personnes.length;i++){
			for (Adresse adresse : personnes[i].getAdresses()) {
				if (adresse.getVille().equals(ville)) {
					count++;
					i=personnes[i].getAdresses().length;
				}
			}
		}
		return count;
	}

	public void editPersonne(String oldNom, String newNom) {
		for (Personne personne : personnes) {
			if (personne.getNom() == oldNom)
				personne.setNom(newNom);
		}
	}

	public void editPersonneVille(String nom, String newVille) {
		for (Personne personne : personnes) {
			if (personne.getNom().equals(nom) == true) {
				for (Adresse adresse : personne.getAdresses()) {
					adresse.setVille(newVille);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "ListePersonnes [personnes=" + Arrays.toString(personnes) + "]";
	}

}
