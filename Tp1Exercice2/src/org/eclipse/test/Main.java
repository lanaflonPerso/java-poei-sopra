package org.eclipse.test;

import org.eclipse.model.Formation;
import org.eclipse.model.Stagiaire;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stagiaire stagiaire = new Stagiaire("Dupond", new float[] { 13, 12, 11 });
		System.out.println("moyenne : " + stagiaire.calculerMoyenne());
		System.out.println("note min : " + stagiaire.trouverMin());
		System.out.println("note max : " + stagiaire.trouverMax());

		Stagiaire stagiaire2 = new Stagiaire("Durand", new float[] { 13, 14, 15 });
		System.out.println("moyenne : " + stagiaire2.calculerMoyenne());
		System.out.println("note min : " + stagiaire2.trouverMin());
		System.out.println("note max : " + stagiaire2.trouverMax());

		Stagiaire stagiaire3 = new Stagiaire("Durand", new float[] { 14, 15, 16 });

		Formation formation = new Formation("Java", 10, new Stagiaire[] { stagiaire, stagiaire2, stagiaire3 });
		System.out.println(formation.calculerMoyenneFormation());
		System.out.println(formation.getIndexMax());
		System.out.println(formation.afficherNomMax());
		System.out.println(formation.afficherMinMax());
		System.out.println(formation.trouverMoyenneParNom("Durand"));
	}

}
