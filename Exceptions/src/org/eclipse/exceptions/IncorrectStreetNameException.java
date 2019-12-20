package org.eclipse.exceptions;

public class IncorrectStreetNameException extends Exception {

	public IncorrectStreetNameException(String rue) {
		System.out.println("Le nom de la rue '" + rue + "' doit être en majuscule");
	}
}
