package org.eclipse.nation;

import org.springframework.stereotype.Component;

@Component
public class French implements European {
	private int rang;

	public int saluer(int i) {
		rang = i;
		System.out.println("Bonjour");
		return ++i;
	}
}
