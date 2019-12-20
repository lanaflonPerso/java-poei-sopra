package org.eclipse.test;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.exceptions.PersonneException;

public class ListePersonnes {
	Map<String, Personne> personnesMap = new HashMap<>();

	public void ajouterPersonne(Personne personne) throws PersonneException {
		if (personnesMap.containsKey(personne.getNomPrenom())) {
			throw new PersonneException();
		} else {
			personnesMap.put(personne.getNomPrenom(), personne);
		}
	}

	public Map<String, Personne> getPersonnesMap() {
		return personnesMap;
	}

	public void setPersonnesMap(Map<String, Personne> personnesMap) {
		this.personnesMap = personnesMap;
	}

	@Override
	public String toString() {
		return "ListePersonnes [personnesMap=" + personnesMap + "]";
	}

}
