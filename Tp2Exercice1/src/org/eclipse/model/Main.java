package org.eclipse.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> stringInt = new HashMap<Integer, String>();
		stringInt.put(7, "Paris");
		stringInt.put(5, "Rome");
		stringInt.put(1, "Manchester");
		stringInt.put(3, "Barcelone");

		String chaine = "Manchester ou Barcelone mais jamais Paris ni Rome";
		StringTokenizer sTokenizer = new StringTokenizer(chaine, " ");
		String result = "";
		while (sTokenizer.hasMoreTokens()) {
			String str = sTokenizer.nextToken();
			boolean trouve = false;
			Integer codeString = null;

			for (Entry<Integer, String> entry : stringInt.entrySet()) {
				if (entry.getValue().equals(str)) {
					trouve = true;
					codeString = entry.getKey();
				}
			}
			result += ((trouve) ? codeString : str) + " ";
		}
		System.out.println(result);
	}
}
