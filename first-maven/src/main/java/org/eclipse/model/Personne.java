package org.eclipse.model;

/**
 * @author Mathilde
 */
public class Personne {
	private int num;
	private String nom;
	private String prenom;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(int num, String nom, String prenom) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @return num : identifiant de la personne, clé primaire de la table personne (auto-incrémentation)
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num : identifiant de la personne (int)
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return nom : nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom : nom de la personne (String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom : prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom : prénom de la personne (String)
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Affichage du contenu de l'objet personne
	 */
	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
