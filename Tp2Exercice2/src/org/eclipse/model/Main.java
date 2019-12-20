package org.eclipse.model;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import org.eclipse.exceptions.PersonneException;
import org.eclipse.test.ListePersonnes;
import org.eclipse.test.Personne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Personne personne1 = new Personne(1, "Durand", "Jacques");
		Personne personne2 = new Personne(2, "Dupond", "Paul");
		Personne personne3 = new Personne(3, "Wick", "John");
		Personne personne4 = new Personne(4, "Green", "Bob");
		Personne personne5 = new Personne(5, "Audois", "Pierre");
		Personne personne6 = new Personne(6, "Wick", "John");

		ListePersonnes listePersonnes = new ListePersonnes();
		Scanner scanner = new Scanner(System.in);
		int recommencer;
		int num;
		do {
			do {
				System.out.println("saisir un numéro > 0");
				num = scanner.nextInt();
			} while (num <= 0);
			scanner.nextLine();
			System.out.println("saisir un nom");
			String nom = scanner.nextLine();
			System.out.println("saisir un prénom");
			String prenom = scanner.nextLine();
			Personne p = new Personne(num, nom, prenom);
			try {
				listePersonnes.ajouterPersonne(p);
			} catch (PersonneException e) {
				e.printStackTrace();
			}
			System.out.println("0 pour quitter, autre valeur pour continuer");
			recommencer = scanner.nextInt();
		} while (recommencer != 0);
		for (Entry<String, Personne> entry : listePersonnes.getPersonnesMap().entrySet()) {
			System.out.println(entry.getValue());
		}
		scanner.close();

//		HashMap<String, Personne> persMap = new HashMap<>();  ---------------- Exercice 2 -----------------------------------------------
//		persMap.put(personne1.getNomPrenom(), personne1);
//		persMap.put(personne2.getNomPrenom(), personne2);
//		persMap.put(personne3.getNomPrenom(), personne3);
//		persMap.put(personne4.getNomPrenom(), personne4);
//		persMap.put(personne5.getNomPrenom(), personne5);

//		int i = 0;
//		for (Entry<String, Personne> entry : persMap.entrySet()) {
//			if (i % 2 == 0) {
//				System.out.println(entry.getKey());
//			} else {
//				System.out.println(entry.getValue());
//			}
//			i++;
//		}

	}

}
