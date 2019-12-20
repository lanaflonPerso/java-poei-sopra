package org.eclipse.model;

import org.eclipse.test.Adresse;
import org.eclipse.test.ListePersonnes;
import org.eclipse.test.Personne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



Adresse adresse1 = new Adresse ("place des marchands", "31370", "Rieumes");
Adresse adresse2 = new Adresse ("chemin des cyprès", "13000", "Aix");
Adresse adresse3 = new Adresse ("chemin des roses", "13010", "Boulogne");
Adresse adresse4 = new Adresse ("allée des roses", "83210", "Blagnac");

Personne personne1 = new Personne("Durand", 'M', new Adresse [] {adresse1});
Personne personne2 = new Personne("Dupond", 'F', new Adresse [] {adresse1, adresse2});
Personne personne3 = new Personne("Durand", 'F', new Adresse [] {adresse2});
Personne personne4 = new Personne("Dupond", 'M', new Adresse [] {adresse1, adresse2});
Personne personne5 = new Personne("Wick", 'M', new Adresse [] {adresse3, adresse4});

ListePersonnes listePersonnes = new ListePersonnes(new Personne [] {personne1, personne2, personne3, personne4, personne5});
//System.out.println(listePersonnes);
//System.out.println(listePersonnes.findByNom("Dupond"));
//System.out.println(listePersonnes.findByNom("Leclercq"));
//System.out.println(listePersonnes.findByCodePostal("13000"));
//System.out.println(listePersonnes.findByCodePostal("83470"));
//System.out.println(listePersonnes.countPersonneVille("Rieumes"));
//System.out.println(listePersonnes.countPersonneVille("Aix"));
//System.out.println(listePersonnes.countPersonneVille("Dunkerque"));
//listePersonnes.editPersonne("Durand", "Leclercq");
//System.out.println(listePersonnes);
//listePersonnes.editPersonneVille("Wick", "Marseille");
//System.out.println(listePersonnes);
	
	}
}
