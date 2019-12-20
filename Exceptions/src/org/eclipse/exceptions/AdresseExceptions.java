package org.eclipse.exceptions;

import org.eclipse.test.Adresse;

public class AdresseExceptions extends Exception {

	public AdresseExceptions(String cp, String rue) {
		if (cp.length() != 5) {
			System.out.println("Le code postal '" + cp + "' doit contenir 5 chiffres.");
		}
		if (!rue.equals(rue.toUpperCase())) {
			System.out.println("Le nom de la rue '" + rue + "' doit être en majuscule");
		}
	}

	public AdresseExceptions(int index, String value) {
		if (index == 0)
			System.out.println("Le code postal '" + value + "' doit contenir exactement 5 chiffres.");
		else
			System.out.print("Le nom de la rue ’" + value + "’ doit être en	majuscule.");
	}

}
