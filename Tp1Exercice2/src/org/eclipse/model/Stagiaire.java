package org.eclipse.model;

import java.util.Arrays;

public class Stagiaire {
	private String nom;
	private float[] notes = new float[3];

	public Stagiaire(String nom, float[] notes) {
		this.nom = nom;
		this.notes = notes;
	}

	public Stagiaire() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float[] getNotes() {
		return notes;
	}

	public void setNotes(float[] notes) {
		this.notes = notes;
	}

	public float calculerMoyenne() {
		int somme = 0;
		for (float note : notes) {
			somme += note;
		}
		return somme / notes.length;
	}

	public float trouverMin() {
		float noteMin = notes[0];
		for (float note : notes) {
			if (note < noteMin)
				noteMin = note;
		}
		return noteMin;
	}

	public float trouverMax() {
		float noteMax = notes[0];
		for (float note : notes) {
			if (note > noteMax)
				noteMax = note;
		}
		return noteMax;
	}

	@Override
	public String toString() {
		return "Stagiaire [nom=" + nom + ", notes=" + Arrays.toString(notes) + "]";
	}

}
