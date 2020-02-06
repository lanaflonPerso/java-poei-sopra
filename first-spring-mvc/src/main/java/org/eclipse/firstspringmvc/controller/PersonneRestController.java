package org.eclipse.firstspringmvc.controller;

import java.util.List;

import org.eclipse.firstspringmvc.dao.AdresseRepository;
import org.eclipse.firstspringmvc.dao.PersonneRepository;
import org.eclipse.firstspringmvc.model.Adresse;
import org.eclipse.firstspringmvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneRestController {
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired 
	private AdresseRepository adresseRepository;

	@GetMapping
	public List<Personne> getPersonnes() {
		return personneRepository.findAll();
	}

	@GetMapping("/{id}")
	public Personne getPersonne(@PathVariable("id") long id) {
		return personneRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Personne addPersonne(@RequestBody Personne personne) {
		System.out.println(personne);
		List<Adresse> adresses= personne.getAdresses();
		for (Adresse adresse:adresses) {
			Adresse ad=null;
			if (adresse.getId()!=null) {
				ad = adresseRepository.findById(adresse.getId()).orElse(null);
				adresses.set(adresses.indexOf(adresse), ad);
			} else {
				ad = adresseRepository.save(adresse);
			}
		}
		return personneRepository.saveAndFlush(personne);
	}
	
	@DeleteMapping("/{id}")
	public void delPersonne(@PathVariable Long id) {
		personneRepository.deleteById(id);
	}
	
	@PutMapping
	public Personne upPersonne (@RequestBody Personne personne) {
		return personneRepository.saveAndFlush(personne);
		
	}
}