package org.eclipse.test;

public class MaDate {
	private int jour;
	private int mois;
	private int annee;

	public MaDate(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	public MaDate() {
		super();
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public void ajouterUnJour() {
		switch (mois) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (jour == 31) {
				jour = 1;
				mois++;
			} else
				jour++;
			break;
		case 12:
			if (jour == 31) {
				jour = 1;
				mois = 1;
				annee++;
			} else
				jour++;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (jour == 30) {
				jour = 1;
				mois++;
			} else
				jour++;
			break;
		case 2:
			if ((annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0)) {
				if (jour == 29) {
					jour = 1;
					mois++;
				} else
					jour++;
			} else {
				if (jour == 28) {
					jour = 1;
					mois++;
				} else
					jour++;
			}
			break;
		}
	}

	public void ajouterPlusieursJours(int n) {
		int i;
		for (i = 0; i == n; i++) {
			ajouterUnJour();
		}
	}

	@Override
	public String toString() {
		return "maDate=" + jour + '/' + mois + '/' + annee;
	}

}
