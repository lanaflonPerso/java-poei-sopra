package org.eclipse.main;

import java.util.List;


import javax.management.Query;

import org.eclipse.model.Adresse;
import org.eclipse.model.Enseignant;
import org.eclipse.model.Etudiant;
import org.eclipse.model.Personne;
import org.eclipse.model.Sport;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotatedClassType;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {
//    	Personne personne = new Personne();
//    	personne.setNom("travolta");
//    	personne.setPrenom("john");
//		Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass(Personne.class);
//		configuration.addAnnotatedClass(Adresse.class);
//		SessionFactory sessionFactory = configuration.buildSessionFactory(); // création de l'usine de management
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//    	Integer cle =(Integer) session.save(personne);
//    	System.out.println(cle);

//    	Personne personne1 =session.get(Personne.class, 1);
//    	System.out.println(personne1);

//		Personne personne3 = session.get(Personne.class, 4);
//		personne3.setNom("Abruzzi");
//
//    	session.flush();
//    	session.delete(personne3);

//    	String string ="travolta";
//    	Criteria criteria =session.createCriteria(Personne.class);
//    	criteria.add(Restrictions.eq("nom", string));
//    	List<Personne> personnes = (List<Personne>) criteria.list(); // on fait un cast sur criteria.list()
//    	for (Personne personne : personnes) {
//    		System.out.println(personne);
//    	}

//    	Personne personne =session.get(Personne.class, 2);
//    	personne.setNom("Wick");
//    	session.refresh(personne); // on a fait un refresh sans avoir au préalable fait de flush, les modifications ne sont donc pas enregistrées dans la DB
//    	session.evict(personne);
//    	session.flush(); // on a fait un evit (personne), les changements sur personne ne seront donc pas pris en compte dans le flush
//    	Personne personne1 = session.get(Personne.class, 2);
//    	System.out.println("le nom est " + personne1.getNom());
//    	

//		String sqlRequete = "select * from personne where nom = :nom ;";
//		SQLQuery query = session.createSQLQuery(sqlRequete); 
//		query.addEntity(Personne.class);
//		query.setParameter("nom", "travolta");
//		List<Personne> personnes = (List<Personne>) query.list();
//		for (Personne personne : personnes) {
//			System.out.println(personne);
//		}
//		//Adresse1
//		Adresse adresse1 = new Adresse();
//		adresse1.setRue("Rue de ddd");
//		adresse1.setCodePostal("13000");
//		adresse1.setVille("Marseille");
//		//adresse2
//		Adresse adresse2 = new Adresse();
//		adresse2.setRue("Rue de eee");
//		adresse2.setCodePostal("31370");
//		adresse2.setVille("Rieumes");
//		//Personne
//		Personne personne= new Personne();
//		personne.setNom("Wick");
//		personne.setPrenom("John");
////		personne.setAdresse(adresse);
//		personne.addAdresse(adresse1);
//		personne.addAdresse(adresse2);
//		//persistance
//		session.persist(personne);

//		Criteria criteria = session.createCriteria(Personne.class);
//		List<Personne> personnes = (List<Personne>) criteria.list();
//		for(Personne personne : personnes) {
//		System.out.println(personne);
//		}
//
//	
//
//		transaction.commit();
//		session.close();
//		sessionFactory.close();

//		Personne p1 = new Personne();
//		Personne p2 = new Personne();
//		p1.setNom("Voight");
//		p1.setPrenom("Bill");
//		p2.setNom("Bob");
//		p2.setPrenom("Joe");
//		Sport s1 = new Sport();
//		Sport s2 = new Sport();
//		Sport s3 = new Sport();
//		s1.setNom("football");
//		s2.setNom("tennis");
//		s3.setNom("boxe");
//		s1.setType("collectif");
//		s2.setType("individuel");
//		s3.setType("collectif ou individuel");
//		p1.addSport(s1);
//		p1.addSport(s3);
//		p2.addSport(s1);
//		p2.addSport(s2);
//		p2.addSport(s3);
//		Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass(Personne.class);
//		configuration.addAnnotatedClass(Adresse.class);
//		configuration.addAnnotatedClass(Sport.class);
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.persist(p1);
//		session.persist(p2);
//		for (Personne personne : s1.getPersonnes())
//			System.out.println(personne.getNom());
//		transaction.commit();
//		session.close();
//		sessionFactory.close();

		/* Personne */
		Personne personne = new Personne();
		personne.setNom("Guardiola");
		personne.setPrenom("Pep");
		/* Enseignant */
		Enseignant enseignant = new Enseignant();
		enseignant.setNom("Ferguson");
		enseignant.setPrenom("Sir");
		enseignant.setSalaire(10000);
		/* ´etudiant */
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Mourinho");
		etudiant.setPrenom("Jose");
		etudiant.setNiveau("Ligue 1");
		/* Persistance */
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Personne.class);
		configuration.addAnnotatedClass(Etudiant.class);
		configuration.addAnnotatedClass(Enseignant.class);
		configuration.addAnnotatedClass(Adresse.class);
		configuration.addAnnotatedClass(Sport.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(personne);
		session.persist(etudiant);
		session.persist(enseignant);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}
