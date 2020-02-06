package org.eclipse.nation;

import org.springframework.stereotype.Component;

@Component
public class Deutsh implements European {
	public int saluer(int i) {
		System.out.println("Gutten tag");
		return i;
	}

}
