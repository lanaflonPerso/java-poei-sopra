package org.eclipse.dao;

import java.util.List;

import org.eclipse.model.Personne;

public interface PersonneDao {
	Personne save(Personne personne);
	void remove(Personne personne);
	Personne update(Personne personne);
	Personne findById(int id);
	List<Personne> getAll();

}
