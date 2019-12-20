package org.eclipse.test;

import org.eclipse.enums.Sports;
import org.eclipse.interfaces.IMiseEnForme;
import org.eclipse.model.Adresse;
import org.eclipse.model.Enseignant;
import org.eclipse.model.Etudiant;
import org.eclipse.model.Personne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sports sport = Sports.BASKET;
		System.out.println(sport);
		
		
//		Adresse adresse = new Adresse("place des marchands", "31370", "RIEUMES");
//		Etudiant etudiant1 = new Etudiant(1, "Wick", "John", adresse, "Bac +5");
//		Etudiant etudiant2 = new Etudiant(2, "Durand", "Paul", adresse, "Bac +3");
//		Enseignant enseignant1 = new Enseignant(3, "Dupond", "Jacques", adresse, 1800);
//		Enseignant enseignant2 = new Enseignant(4, "Mike", "Bob", adresse, 2000);
//
//		enseignant1.afficherNomMajuscule();
//		etudiant2.afficherPrenomMajuscule();
//		System.out.println(etudiant1.i);
//		System.out.println(enseignant2.i);
//		
//		Personne[] tab = {etudiant1, etudiant2, enseignant1, enseignant2};
//		for (Personne person : tab) {
//			if (person instanceof Enseignant == true) {
//				System.out.println(((Enseignant) person).getSalaire());
//			} else {
//				System.out.println(((Etudiant) person).getNiveau());
//			}
//		}

//		Personne personne = new Personne(1, "Wick", "John", adresse);
//		System.out.println(personne);
//		System.out.println(
//				personne.getNum() + " " + personne.getNom() + " " + personne.getPrenom() + " " + personne.getAdresse());
//
//		Enseignant enseignant = new Enseignant(2, "Durand", "Jacques", adresse, 1800);
//		System.out.println(enseignant);

//		Personne personne = new Personne();
//		personne.setNum(1);
//		personne.setNom("Wick");
//		personne.setPrenom("John");
//		System.out.println(personne.getNum() + " " + personne.getNom() + " " + personne.getPrenom());
//		System.out.println(Personne.getNbrPersonnes());
//		Personne personne2 = new Personne(2, "Bob", "Mike");
//		System.out.println(personne2);
//		System.out.println(Personne.getNbrPersonnes());
	}

}
