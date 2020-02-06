package org.eclipse.nation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

	Car car;

	public void drive() {
		System.out.println("Je suis prêt à conduire");
		car.start();
	}

}
