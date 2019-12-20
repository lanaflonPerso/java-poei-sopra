package org.eclipse.interfaces;

public interface IMiseEnForme {

	int i = 5;

	default public void afficherNomMajuscule() {
		System.out.println("DOE");
	}

	public void afficherPrenomMajuscule();
	
}
