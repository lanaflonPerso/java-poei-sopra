package org.eclipse.excrudspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.eclipse.excrudspring.dao.PersonneRepository;
import org.eclipse.excrudspring.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes("user")
public class ConnexionController {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("/connect")
	public String getConnexion(Model model) {
		model.addAttribute("user", new Personne());
		return "connectForm";
	}

	@PostMapping("/connect")
	public String checkUser(@ModelAttribute("user") Personne personne, Model model, WebRequest request) {
		List<Personne> personnes = personneRepository.findByNomAndPrenom(personne.getNom(), personne.getPrenom());
		if (personnes.size() == 0) {
			return "redirect:deconnect"; // on redirige vers la déconnexion pour vider la session en cas de mauvaise
											// saisie (aucun mauvais id ne sera stocké dans la session
		} else {
			return "redirect:personne"; // redirect = on accède à la Servlet plutôt que d'afficher la vue directement
		}
	}

	@GetMapping("/deconnect")
	public String deconnect(WebRequest request) {
		request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "redirect:connect";
	}

}
