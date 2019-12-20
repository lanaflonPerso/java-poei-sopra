package org.eclipse.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP HASHMAP 

		List list = Arrays.asList(2, 5, "Bonjour", true, 'c', "3", "b", false, 10);

		HashMap<String, Integer> contenu = new HashMap();
		for (Object elt : list) {
			String type = elt.getClass().getSimpleName();
			if (contenu.containsKey(type)) {
				contenu.put(type, contenu.get(type) + 1);
			} else {
				contenu.put(type, 1);
			}
		}

		for (Entry<String, Integer> entry : contenu.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

//		HashMap<String, Integer> repetition = new HashMap();   // exercice1 --------------------------------------
//		repetition.put("Java", 2);
//		repetition.put("PHP", 5);
//		repetition.put("C++", 1);
//		repetition.put("HTML", 4);
//
//		for (Entry<String, Integer> entry : repetition.entrySet()) {
//			for (int i = 0; i < entry.getValue(); i++) {
//				System.out.print(entry.getKey());
//			}
//			System.out.print(" ");
//		}

//		HashMap<Integer, String> hMap =new HashMap<>();
//		hMap.put(1, "Java");
//		hMap.put(2, "PHP");
//		hMap.put(10, "C++");
//		hMap.put(17, null);
//		for (Entry<Integer, String> entry : hMap.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		

// HASHTABLE HASHTABLE HASHTABLE HASHTABLE HASHTABLE HASHTABLE HASHTABLE HASHTABLE HASHTABLE -------------------
//		Hashtable ht = new Hashtable<>();
//		ht.put(1, "Java");
//		ht.put(2, "PHP");
//		ht.put(10, "C++");
//		ht.put(17, "Pascal");
//		
//		Enumeration enumeration = ht.elements();
//		while (enumeration.hasMoreElements()) {
//			System.out.println(enumeration.nextElement());
//		}

// LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST -----------------------		

//		Integer[] tab = { 2, 7, 2, 1, 3, 9, 2, 4, 2 };
//		ArrayList liste = new ArrayList(Arrays.asList(tab));
//		int valeur = 2;
//		ArrayList indiceListe = new ArrayList();
//
//		// correction Achref pour supprimer avant dernière occurence:
//		System.out.println(liste);
//		liste.remove(liste.subList(0, liste.lastIndexOf(2)).lastIndexOf(2));
//		System.out.println(liste);

//		System.out.println(liste);
//		for (int i=0; i<=liste.size()-1;i++) {
//			if (liste.get(i).equals(valeur)) {
//				indiceListe.add(i);
//			}
//		}
//		System.out.println(liste.size());
//		System.out.println(indiceListe);
//		System.out.println(indiceListe.size()-2);
//		System.out.println(indiceListe.get(indiceListe.size()-2));
//		liste.remove((int)indiceListe.get(indiceListe.size()-2)); // on supprime l'avantd ernière occurence de la valeur choisie
//		System.out.println(liste);
//		System.out.println(liste.size());

//		ArrayList liste = new ArrayList();
//		Scanner scanner = new Scanner(System.in);
//		for (int i = 0; i < 5; i++) {
//			System.out.println("Saisir valeur " + i);
//			liste.add(scanner.nextInt());
//		}
//		System.out.println(liste);
//		System.out.println("saisir la valeur à supprimer");
//		int valeur = scanner.nextInt();
//		scanner.close();
//
//		while (liste.contains((Integer) valeur)) // on supprime toutes les occurences de la valeur indiquée
//			liste.remove((Integer) valeur);
//		System.out.println(liste);

//		liste.remove((Integer) valeur); // on supprime la 1ère occurence de la valeur indiquée
//		System.out.println(liste);

//		ArrayList liste = new ArrayList();
//		liste.add(3);
//		liste.add("Bonjour");
//		liste.add(3.5);
//		liste.add('c');
//		for (int i = 0; i < liste.size(); i++) {
//			System.out.println("élément d'indice " + i + " = " + liste.get(i));
//		}

	}

}
