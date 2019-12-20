package org.eclipse.model;

import org.eclipse.exceptions.AdresseExceptions;
import org.eclipse.exceptions.IncorrectCodePostalException;
import org.eclipse.exceptions.IncorrectStreetNameException;
import org.eclipse.test.Adresse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x = 5, y = 0;
//		try {
//			System.out.println(x / y);
//		} catch (Exception e) {
////			System.out.println("Exception : division par zéro");
////			System.out.println("Exception : " + e.getMessage());
//			e.printStackTrace();
//		}
//		System.out.println("Fin de calcul");

		Adresse a = null;

		try {
			a = new Adresse("rue de Paradis", "Marseille", "1300");
		} catch (AdresseExceptions ae) {
			ae.printStackTrace();
		} finally {
			System.out.println("Instruction éxécutée de manière systématique");
		}
	}
}