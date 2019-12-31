package org.eclipse.model;

@FunctionalInterface
public interface IMiseEnForme {

	public void afficherDetails();

	default public void afficherNomComplet(String nom, String prenom) {
		System.out.println(nom + " " + prenom);
	}
	
}
