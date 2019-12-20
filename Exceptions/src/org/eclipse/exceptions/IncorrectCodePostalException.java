package org.eclipse.exceptions;

public class IncorrectCodePostalException extends Exception {
	public IncorrectCodePostalException(String cp) {
		System.out.println("Le code postal '" + cp + "' doit contenir exactement 5 chiffres");
	}

}
