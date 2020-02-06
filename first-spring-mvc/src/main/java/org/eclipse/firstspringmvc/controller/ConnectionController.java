package org.eclipse.firstspringmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.eclipse.firstspringmvc.dao.PersonneRepository;
import org.eclipse.firstspringmvc.model.Personne;
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
@SessionAttributes("perso")
public class ConnectionController {
	@Autowired
	PersonneRepository personneRepository;

	@GetMapping("/connect")
	public String personneForm(Model model) {
		model.addAttribute("perso", new Personne());
		return "connectForm";
	}

	@PostMapping("/connect")
	public String checkData(@ModelAttribute("perso") @Valid Personne personne, BindingResult result, Model model,
			WebRequest request) {
		if (result.hasErrors()) {
			return "connectForm";
		}
		List<Personne> personnes = personneRepository.findByNomAndPrenom(personne.getNom(), personne.getPrenom());
		if (personnes.size() > 0) {
			request.setAttribute("connected", true, WebRequest.SCOPE_SESSION);
			return "redirect:personne";
		}
		return "connectForm";
	}

	@GetMapping("/deconnect")
	public String leave(WebRequest request) {
		request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
		request.removeAttribute("perso", WebRequest.SCOPE_SESSION);
		return "redirect:connect";
	}
}