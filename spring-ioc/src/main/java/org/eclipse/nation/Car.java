package org.eclipse.nation;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public void start() {
		System.out.println("Voiture démarée et prête à rouler.");
	}
}
