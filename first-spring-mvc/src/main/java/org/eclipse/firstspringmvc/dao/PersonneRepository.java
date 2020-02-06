package org.eclipse.firstspringmvc.dao;

import java.util.List;

import org.eclipse.firstspringmvc.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	List<Personne> findByNomAndPrenom(String nom, String prenom);
	List<Personne> findByNom(String nom);
	List<Personne> findByPrenomEndingWith(String end);
	List<Personne> findByNomEndingWithOrPrenomEndingWith(String endName, String endFirstName);
	

}
