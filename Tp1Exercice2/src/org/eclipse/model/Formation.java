package org.eclipse.model;

import java.util.Arrays;

public class Formation {
	private String intitule;
	private int nbrJours;
	private Stagiaire[] stagiaires;

	public Formation(String intitule, int nbrJours, Stagiaire[] stagiaires) {
		super();
		this.intitule = intitule;
		this.nbrJours = nbrJours;
		this.stagiaires = stagiaires;

	}

	public Formation() {
		super();
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getNbrJours() {
		return nbrJours;
	}

	public void setNbrJours(int nbrJours) {
		this.nbrJours = nbrJours;
	}

	public Stagiaire[] getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Stagiaire[] stagiaires) {
		this.stagiaires = stagiaires;
	}

	public float calculerMoyenneFormation() {
		int somme = 0;
		for (Stagiaire personne : stagiaires) {
			somme += personne.calculerMoyenne();
		}
		return somme / stagiaires.length;
	}

	public int getIndexMax() {
		int indexMax;
		if (stagiaires.length == 0)
			indexMax = -1;
		else {
			indexMax = 0;
			int i;
			for (i = 1; i < stagiaires.length; i++) {
				if (stagiaires[i].calculerMoyenne() > stagiaires[indexMax].calculerMoyenne())
					indexMax = i;
			}
		}
		return indexMax;
	}

	public String afficherNomMax() {
		Stagiaire stagiaireMax = stagiaires[getIndexMax()];
		return stagiaireMax.getNom();
	}

	public float afficherMinMax() {
		Stagiaire stagiaireMax = stagiaires[getIndexMax()];
		return stagiaireMax.trouverMin();
	}

	public float trouverMoyenneParNom(String nom) {
		float res = 0;
//		for (Stagiaire personne : stagiaires) {
//			if (personne.getNom() == nom)
//				res = personne.calculerMoyenne();
//		}
		int i;
		for (i = 0; i < stagiaires.length; i++) {
			if (stagiaires[i].getNom() == nom) {
				res = stagiaires[i].calculerMoyenne();
				i = stagiaires.length;
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "Formation [intitule=" + intitule + ", nbrJours=" + nbrJours + ", stagiaires="
				+ Arrays.toString(stagiaires) + "]";
	}

}
