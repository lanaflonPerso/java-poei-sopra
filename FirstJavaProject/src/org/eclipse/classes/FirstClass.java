package org.eclipse.classes;

import java.util.Scanner;

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisir la taille du tableau");
		var x = scanner.nextInt();
		String[] tab = new String[x];
		scanner.nextLine();

		int i;
		for (i = 0; i < x; i++) {
			System.out.println("Saisir une chaine de caractère");
			tab[i] = scanner.nextLine();
		}
		scanner.close();

		int j;
		int indiceMax=0;
		for (j = 0; j < x - 1; j++) {
			if (tab[j].length() > tab[j + 1].length()) {
				indiceMax = j;
			}
		}
		System.out.println("la chaîne la plus longue est : " + tab[indiceMax]);
		

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Saisir un mot");
//		String str = scanner.next();
//		System.out.println("Saisir une lettre");
//		char lettre = scanner.next().charAt(0);
//		scanner.close();
//		int i;
//		for (i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == lettre) {
//				System.out.print(i + " ");
//			}
//		}

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Saisir un mot");
//		String str = scanner.next();
//		scanner.close();
//		int i = 0;
//		while (i != str.length()) {
////			if (i % 2 == 0) {
////				System.out.print(String.valueOf(str.charAt(i)).toUpperCase());
////			} else {
////				System.out.print(String.valueOf(str.charAt(i)).toLowerCase());
////			}
////			i++;
//			// écriture simplifiée ci-dessous :
//			System.out.print(i % 2 == 0 ? str.toUpperCase().charAt(i++) : str.toLowerCase().charAt(i++));
//		}

//		var x = Math.round(Math.random() * (10) - 5);
//		System.out.println(x);
//		if (x == 0) {
//			System.out.println("cet entier est nul");
//		}
//		else if (x<0) { 
//			System.out.println("cet entier est négatif");
//		}
//		else {
//			System.out.println("cet entier est positif");
//		}

//		int x = 100;
//		byte z = (byte) x;
//		System.out.println(z);
//
//		String str = "bonjour";
//		System.out.println(str);
//		System.out.println(str.contains("o"));
//		System.out.println(str.replace("o", "a"));
//		System.out.println(str.charAt(2));
//		String str2 = "bonsoir";
//		System.out.println(str.contentEquals(str2));
//		String str3 = "4";
//		byte y = Byte.parseByte(str3);
//		System.out.println(y);
//		var c = 10;
//		System.out.println(c);

//		Scanner scanner = new Scanner(System.in);
//		int i = scanner.nextInt();
//		System.out.println(i);
//		scanner.close();

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Saisir une valeur a");
//		int a = scanner.nextInt();
//		System.out.println("Saisir une valeur b");
//		int b = scanner.nextInt();
//		scanner.close();
//		System.out.println("a + b = " + (a + b));
//		System.out.println("a - b = " + (a - b));
//		System.out.println("a * b = " + (a * b));
//		System.out.println("a / b = " + ((float)a / b));

//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.next();
//		System.out.println(str);
//		String string = scanner.nextLine();
//		System.out.println(string);
//		scanner.close();

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("saisir un mot");
//		String strg = scanner.nextLine();
//		System.out.println(strg.charAt(0));
//		System.out.println(strg.charAt(strg.length()-1));
//		scanner.close();

//		var x = Math.random() * 5 + 1;
//		System.out.println(Math.round(x));

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Saisir une valeur a");
//		int a = scanner.nextInt();
//		System.out.println("Saisir une valeur b");
//		int b = scanner.nextInt();
//		System.out.println("saisir un opérateur");
//		String op = scanner.next();
//		scanner.close();
//
//		if (op.equals("+") == true) {
//			System.out.println("a + b = " + (a + b));
//		} 
//		else if (op.equals("-") == true) {
//			System.out.println("a - b = " + (a - b));
//		} 
//		else if (op.equals("*") == true) {
//			System.out.println("a * b = " + (a * b));
//		} 
//		else if (op.equals("/") == true) {
//			System.out.println("a / b = " + ((float) a / b));
//		}
	}

}
