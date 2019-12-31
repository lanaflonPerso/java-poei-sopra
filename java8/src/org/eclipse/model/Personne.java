package org.eclipse.model;

public class Personne {
	private String nom;
	private String prenom;
	private int age;
//	public IMiseEnForme iMiseEnForme = new IMiseEnForme() {
//
//		@Override
//		public void afficherDetails() {
//			// TODO Auto-generated method stub
//			System.out.println("nom = " + nom + ", pr�nom = " + prenom + ", �ge = " + age + ".");
//
//		}
//	};
	// on peut remplacer par l'expression lambda suivante :
	public IMiseEnForme iMiseEnForme = () -> System.out
			.println("nom = " + nom + ", pr�nom = " + prenom + ", �ge = " + age + ".");
	// IMiseEnForme est une interface fnelle, () renvoie donc bien vers la seule
	// m�thode abstraite, pas besoin d'en pr�ciser le nom

	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Personne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

}
