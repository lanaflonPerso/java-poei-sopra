package org.eclipse.firstspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping(value = "/hello")
	public ModelAndView sayHello(ModelAndView mv) {
		mv.setViewName("hello");
		mv.addObject("nom", "Wick");
		return mv;
	}
//
//	@GetMapping(value = "/hello/{nom}")
//	public String sayHello(@PathVariable String nom) {
//		return "hello";
//	}

}
