package org.eclipse.firstspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationController {

	@GetMapping(value = "operation/{op}")
	public void calcul(@PathVariable String op, 
			@RequestParam(value = "x", required = false, defaultValue = "0") int x,
			@RequestParam(value = "y", required = false, defaultValue = "1") int y) {

		int result=x+y;
		
		if(op.equals("plus")) result=x+y;
		else if (op.equals("moins")) result = x-y;
		else if (op.equals("fois")) result = x*y;
		else if (op.equals("div")) result = x+y;
		
		
		System.out.println(result);

	}
}
