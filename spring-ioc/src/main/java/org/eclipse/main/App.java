package org.eclipse.main;

import org.eclipse.nation.European;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//       Personne p =context.getBean("per", Personne.class);
//       p.afficher();

		European european = (European) context.getBean("french");
		european.saluer(1);
		
		European european2= (European) context.getBean("deutsh");
		european2.saluer(3);

	}
}
