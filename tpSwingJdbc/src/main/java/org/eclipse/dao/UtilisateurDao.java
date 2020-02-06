package org.eclipse.dao;

import java.util.List;

import org.eclipse.model.Utilisateur;

public interface UtilisateurDao {
	Utilisateur save(Utilisateur utilisateur);
	void remove(Utilisateur utilisateur);
	Utilisateur update(Utilisateur utilisateur);
	Utilisateur findById(int id);
	List<Utilisateur> getAll();

}
