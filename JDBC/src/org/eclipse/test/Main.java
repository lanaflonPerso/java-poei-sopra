package org.eclipse.test;

import java.sql.ResultSet;
import java.util.Scanner;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		String url = "jdbc:mysql://localhost:3306/jdbc?autoReconnect=true&useSSL=false";
//		String user = "root";
//		String password = "root";
//		Connection connexion = null;

//		try {
//			connexion = DriverManager.getConnection(url, user, password);
//			Statement statement = connexion.createStatement();
//			String request = "select * from personne;";
//			ResultSet result = statement.executeQuery(request);
//
//			while (result.next()) {
//				int idPersonne = result.getInt("num");
//				String nom = result.getString("nom");
//				String prenom = result.getString("prenom");
//				System.out.println(idPersonne + " : " + nom + " " + prenom);
//			}

//			Statement statement2 = connexion.createStatement();
//			String request2 = "insert into Personne (nom,prenom) values ('Audois','Pierre');";
//			int nbr = statement2.executeUpdate(request2, Statement.RETURN_GENERATED_KEYS);
//			ResultSet primaryKey = statement2.getGeneratedKeys();
//
//			if (nbr != 0) System.out.println("Insertion réussie");
//			if (primaryKey.next()) {
//				System.out.println("Clé primaire générée pour cette personne : " + primaryKey.getInt(1));
//			}

//			String request3 = "insert into Personne (nom,prenom) values (?,?);";
//			PreparedStatement ps3 = connexion.prepareStatement(request3, PreparedStatement.RETURN_GENERATED_KEYS);
//			ps3.setString(1, "Wick");
//			ps3.setString(2, "John");
//			ps3.executeUpdate();
//			ResultSet primaryKey3 = ps.getGeneratedKeys();
//
//			if (primaryKey3.next()) {
//				System.out.println("Clé primaire générée pour cette personne : " + primaryKey3.getInt(1));
//			}
//
//			String request4 = "update personne set nom=? where prenom =?;";
//			PreparedStatement ps4 = connexion.prepareStatement(request4);
//			ps4.setString(1, "Doe");
//			ps4.setString(2, "John");
//			ps4.executeUpdate();
//			
//			String request5 ="delete from personne where num=?;";
//			PreparedStatement ps5 =connexion.prepareStatement(request5);
//			ps5.setInt(1, 9);
//			ps5.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (connexion != null) {
//				try {
//					connexion.close();
//				} catch (SQLException ignore) {
//					// TODO Auto-generated catch block
//					ignore.printStackTrace();
//				}
//
//			}
//		}

//		PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
//		Personne personne = new Personne("Wick", "John");
//		Personne insertedPersonne = personneDaoImpl.save(personne);
//		if (insertedPersonne != null)
//			System.out.println("personne numéro " + insertedPersonne.getNum() + " a été insérée");
//		else
//			System.out.println("problème d'insertion");

//		System.out.println(personneDaoImpl.getAll());
//		PersonneDaoImpl dao = new PersonneDaoImpl();
//		Personne personne2 = dao.findById(4);
//		System.out.println(personne2);
//
//		if (personne2 != null) {
//			personne2.setNom("Travolta");
//			dao.update(personne2);
//		}
//		var personnes = dao.getAll();
//		personnes.forEach(System.out::println);

		// ----------- exo avec les menus
		PersonneDaoImpl daoEx = new PersonneDaoImpl();
		System.out.println("1 - Insérer une nouvelle personne");
		System.out.println("2 - Modifier une personne");
		System.out.println("3 - Supprimer une personne");
		System.out.println("4 - afficher toutes les personnes");
		Scanner menu = new Scanner(System.in);
		System.out.println("Saisir le chiffre correspondant à votre choix.");
		int choix = menu.nextInt();

		// menu.close();

		if (choix == 1) {
			// Scanner ajoutPersonne = new Scanner(System.in);
			System.out.println("Saisir le nom de la personne à ajouter:");
			String nom = menu.next();
			System.out.println("Saisir le prénom de la personne à ajouter:");
			String prenom = menu.next();
			Personne personne = new Personne(nom, prenom);
			Personne insertedPersonne = daoEx.save(personne);
			if (insertedPersonne != null) {
				System.out.println("Personne ajoutée avec succès!");
			} else
				System.out.println("Oups : problème d'insertion.");
			personne.setNum(insertedPersonne.getNum());
		}

		else if (choix == 2) {
			System.out.println("Saisir l'identifiant de la personne à modifier :");
			int id = menu.nextInt();
			Personne updatePersonne = daoEx.findById(id);
			System.out.println("Voici la personne à modifier : " + updatePersonne);
			System.out.println("Saisir un nouveau nom :");
			String nom = menu.next();
			System.out.println("Saisir un nouveau prénom : ");
			String prenom = menu.next();
			updatePersonne.setNom(nom);
			updatePersonne.setPrenom(prenom);
			daoEx.update(updatePersonne);
		}

		else if (choix == 3) {
			System.out.println("Saisir l'identifiant de la personne à supprimer : ");
			int id = menu.nextInt();
			Personne delPersonne = daoEx.findById(id);
			System.out.println("Voici la personne à supprimer : " + delPersonne);
			menu.close();
			daoEx.remove(delPersonne);
		}

		else if (choix == 4) {
			System.out.println("Voici la liste des personnes :");
			daoEx.getAll().forEach(System.out::println);
		}
	}

}
