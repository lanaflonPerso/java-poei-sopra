package org.eclipse.model;

import org.eclipse.test.Exemple;
import org.eclipse.test.Operation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operation<Integer> operation1 = new Operation<Integer>(5, 3);
		operation1.plus();
		Operation<String> operation2 = new Operation<String>("bon", "jour");
		operation2.plus();
		Operation<Double> operation3 = new Operation<Double>(5.2, 3.8);
		operation3.plus();
		Operation<Boolean> operation4 = new Operation<Boolean>(true, false);
		operation4.plus();

//		Exemple<Integer> entier = new Exemple<Integer>();
//		entier.setVar(10);
//		System.out.println(entier.getVar().getClass().getTypeName() + " " + entier.getVar());
//
//		Exemple<String> chaine = new Exemple<String>();
//		chaine.setVar("hello");
//		System.out.println(chaine.getVar().getClass().getTypeName() + " " + chaine.getVar());

	}
}
