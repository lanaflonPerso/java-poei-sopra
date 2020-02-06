package org.eclipse.excrudspring.controller;

import java.lang.invoke.StringConcatFactory;
import java.util.List;

import org.eclipse.excrudspring.dao.PersonneRepository;
import org.eclipse.excrudspring.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/personne")
public class PersonneController {
	@Autowired
	PersonneRepository personneRepository;

	@GetMapping
	public String homepage(Model model, WebRequest request) {
		Personne pers= (Personne) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		if (pers!=null && pers.getNom()!=null) {
		model.addAttribute("personne", new Personne());
		model.addAttribute("personnes", personneRepository.findAll());
		return "personne";
				}
		else return "redirect:/connect";
	}

	@GetMapping("/supprimer/{num}")
	public String supprimerPersonne(@PathVariable Long num, Model model) {
		personneRepository.deleteById(num);
		return "redirect:" + "/personne";
	}

	@GetMapping("/details/{num}")
	public String afficherDetails(@PathVariable Long num, Model model) {
		Personne personne = personneRepository.findById(num).orElse(null);
		model.addAttribute("persDetails", personne);
		return "details";
	}

	@PostMapping("/ajouter")
	public String ajouterPersonne(@ModelAttribute("user") Personne personne, Model model) {
		personneRepository.save(personne);
		return "redirect:" + "/personne";
	}

	@GetMapping("/modifier/{num}")
	public String modifierPersonne(@PathVariable Long num, Model model) {
		Personne personne = personneRepository.findById(num).orElse(null);
		model.addAttribute("persUpd", personne);
		return "modifier";
	}

	@PostMapping("/modifier")
	public String modifierPersonne(@ModelAttribute("persUpd") Personne personne) {
		System.out.println(personne);
		personneRepository.saveAndFlush(personne);
		return "redirect:" + "/personne";

	}
}
