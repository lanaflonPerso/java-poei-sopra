package org.eclipse.firstspringmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.firstspringmvc.dao.PersonneRepository;
import org.eclipse.firstspringmvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//@Secured("ROLE_ADMIN")
@Controller
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;
	//@PreAuthorize("hasRole('ROLE_USER') and hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/addPerson")
	public String addPerson() {
		return "addPerson";
	}
	
	@GetMapping(value = "/showAll")
	public ModelAndView showAll() {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}

	@GetMapping(value = "/showAllByPage/{i}/{j}")
	public ModelAndView showAllByPage(@PathVariable int i, @PathVariable int j) {
		Page<Personne> personnes = personneRepository.findAll(PageRequest.of(i, j));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes.getContent());
		return mv;
	}

	@GetMapping(value = "/showAllSorted")
	public ModelAndView showAllSorted() {
		List<Personne> personnes = personneRepository.findAll(Sort.by("nom").ascending());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}

	@GetMapping(value = "/show/{id}")
	public ModelAndView showAll(@PathVariable Long id) {
		Personne personne = personneRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultById");
		mv.addObject("nom", personne.getNom());
		mv.addObject("prenom", personne.getPrenom());
		return mv;
	}

	@GetMapping(value = "/showSome")
	public ModelAndView showSome(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneRepository.findByNomAndPrenom(nom, prenom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}

	@GetMapping(value = "/showSomeName")
	public ModelAndView showSome(@RequestParam(value = "nom") String nom) {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneRepository.findByNom(nom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}

	@GetMapping(value = "/showSomeByEndOfFirstName")
	public ModelAndView showSomeByEndOfFirstName(@RequestParam(value = "end") String end) {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneRepository.findByPrenomEndingWith(end);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}

	@GetMapping(value = "/showSomeByEnd")
	public ModelAndView showSomeByEnd(@RequestParam(value = "endName") String endName,
			@RequestParam(value = "endFirstName") String endFirstName) {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneRepository
				.findByNomEndingWithOrPrenomEndingWith(endName, endFirstName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("personnes", personnes);
		return mv;
	}
	@RequestMapping(value = "/addPerson",  method = RequestMethod.POST)
	public ModelAndView addPerson(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		Personne p1 = new Personne(nom, prenom);
		personneRepository.save(p1);
		System.out.println(p1);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirm");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		return mv;
	}

}
