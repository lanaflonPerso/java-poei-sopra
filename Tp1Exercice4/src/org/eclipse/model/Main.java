package org.eclipse.model;

import org.eclipse.test.MaDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaDate date = new MaDate(26, 02, 1990);
		date.ajouterUnJour();
		System.out.println(date);
	}

}
