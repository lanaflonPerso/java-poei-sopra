package org.eclipse.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.model.ICalcul;
import org.eclipse.model.Personne;

public class Main {

//	public static List<String> listToString(List<Personne> personnes) {
//	Function<Personne, String> personneToString = (p) -> p.getAge() % 2 == 0 ? p.getNom() : p.getPrenom();
//	List<String> chaines = new ArrayList<String>();
//	for (Personne personne : personnes) {
//		chaines.add(personneToString.apply(personne));
//	}
//	return chaines;
//}

//	public static int somme(int x, int y) {
//		return x + y;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Personne personne = new Personne("Leclercq", "Mathilde", 29);
//		personne.iMiseEnForme.afficherDetails();
//		personne.iMiseEnForme.afficherNomComplet(personne.getNom(), personne.getPrenom());
//		System.out.println(personne.iMiseEnForme.getClass());
//		System.out.println(personne.iMiseEnForme.getClass().getSuperclass());
//		

//		ICalcul plus = (int x, int y) -> x + y;
//		System.out.println(plus.operationBinaire(3, 5));
//
//		int i = 2;
//		int j = 3;
//
//		ICalcul calculComplexe = (int x, int y) -> x * i + y * j;
//		System.out.println(calculComplexe.operationBinaire(3, 5));
//		// on ne peut pas mofidier i ou j dans l'expression lambda!
//
//		Function<Personne, String> personneToString = (p) -> p.getNom() + "" + p.getPrenom();
//		System.out.println(personneToString.apply(personne));

//		List<Personne> listePersonnes = Arrays.asList(new Personne("Durand", "Jacques", 46),
//				new Personne("Dupond", "Paul", 33), new Personne("Audois", "Pierre", 29),
//				new Personne("Ross", "Mike", 28));
//
//		System.out.println(listToString(listePersonnes));
//
//		Function<Personne, String> personneToStr = (p) -> p.getNom() + "" + p.getNom();
//		Function <String, Integer> strToInt = (str) -> str.length();
//		Function <Personne, Integer> persToInt = personneToStr.andThen(strToInt);
//		
//		int longueur=persToInt.apply(personne);
//		System.out.println(longueur);

		// expression lambda pour trouver valeur max du tableau
//		Function<List<Integer>, Integer> chercherMax = (tab) -> {
//			Integer max = tab.get(0);
//			for (Integer entier : tab) {
//				if (entier > max)
//					max = entier;
//			}
//			return max;
//		};

//		BinaryOperator<Integer> somme = (a, b) -> a + b;
//		System.out.println(somme.apply(10, 12));
//
//		BinaryOperator<String> sommeStr = (a, b) -> a + " " + b;
//		System.out.println(sommeStr.apply("hello", "world!"));
//
//		BiFunction<List<Integer>, List<Integer>, Integer> sommeMax = (a, b) -> somme.apply(chercherMax.apply(a),
//				chercherMax.apply(b));
//
//		List<Integer> tab1 = Arrays.asList(-15, 10, 12);
//		List<Integer> tab2 = Arrays.asList(17, 13, 18);
////		
////		System.out.println(chercherMax.apply(tab1));
////		System.out.println(chercherMax.apply(tab2));
//		System.out.println(sommeMax.apply(tab1, tab2));
//
//		BinaryOperator<Integer> calculPuissance = (x, n) -> (int) Math.pow(x, n);
//		System.out.println(calculPuissance.apply(3, 2));

//		BiPredicate<Personne, Integer> contrainteAge = (p, x) -> p.getAge() >= x;
//		if (contrainteAge.test(personne, 18))
//			System.out.println(personne.getPrenom() + " , vous êtes adulte !");

//		Supplier<Double> reel = () -> Math.random() * 100;
//		System.out.println(reel.get());

//		ICalcul iCalcul = Main::somme;
//		System.out.println(iCalcul.operationBinaire(3,2));
//
//		Supplier<Personne> constructeur = Personne :: new;
//		Personne p=constructeur.get(); // attention, il faut générer le constructeur sans paramètres dans la classe Personne
//		System.out.println(p);
//		p.setNom("Durand");
//		System.out.println(p);

//		List<Integer> liste = new ArrayList<Integer>(Arrays.asList(2, 7, 1, 3));
//		liste.forEach(elt -> System.out.println(elt)); // on ne peut pas appliquer filter, map, reduce... à une liste

//		Stream<Integer> stream = liste.stream(); // ---- il faut convertir la liste en stream
//		stream.forEach(elt -> System.out.println(elt));

//		Optional<Integer> somme = stream.map(elt -> elt + 2).filter(elt -> elt > 3).reduce((a, b) -> a + b);
//		if (somme.isPresent())
//			System.out.println(somme.get());
//		liste.forEach(elt -> System.out.println(elt));
//		liste = stream.map(elt -> elt + 2).filter(elt -> elt > 3).collect(Collectors.toList());
//		liste.forEach(elt -> System.out.println(elt));

//		long nbr = stream.map(elt -> elt + 2).filter(elt -> elt > 3).count();
//		System.out.println(nbr);

//		boolean result = stream.map(elt -> elt + 2).filter(elt -> elt > 3).anyMatch(elt->elt==9);
//		System.out.println(result);

//		List<String> listeStr = Arrays.asList("bonjour", "hello", "ciao", "hi");
//		Stream<String> streamStr = listeStr.stream();
//
//		System.out.println("Saisir un nombre de caractères");
//		Scanner scanner = new Scanner(System.in);
//		int x = scanner.nextInt();
//		scanner.close();
//
//		if (streamStr.anyMatch(elt -> elt.length() == x)) {
//			System.out.println("Il y a bien un mot qui contient " + x + " caractères.");
//		}
//		else System.out.println("Il n'y a aucun mot qui contienne exactement " + x + " caractères.");

//		ArrayList<Integer> listeInt = new ArrayList<Integer>();
//		Scanner scannerInt = new Scanner(System.in);
//		System.out.println("Saisir un entier positif");
//		Integer x = scannerInt.nextInt();
//
//		while (x > 0) {
//			final int k = x;
//			listeInt.add(x);
//			System.out.println("Occurence(s) de " + k + " = " + listeInt.stream().filter(elt -> elt == k).count());
//			System.out.println("Saisir un nouvel entier positif pour continuer");
//			x = scannerInt.nextInt();
//		}
//		System.out.println("Fin du programme.");

//		IntStream stream = IntStream.range(0, 6);
//		stream.skip(3).forEach(System.out::println);
//		IntStream stream2 = IntStream.iterate(1, num -> num + 1).limit(10);
//		stream2.forEach(System.out::println);
//		System.out.println(stream2.sum());

//		ArrayList<Integer> liste = new ArrayList<Integer>();
//		
//		Scanner valListe = new Scanner(System.in);
//		System.out.println("Saisir un entier positif.");
//		int x = valListe.nextInt();
//		while (x > 0) {
//			liste.add(x);
//			System.out.println("Saisir un nouvel entier positif pour continuer");
//			x = valListe.nextInt();
//		}
//		valListe.close();
//		System.out.println(liste);
//		
//		System.out.println("Valeur max = " + liste.stream().mapToInt(Integer::intValue).max().orElse(-1));
//		System.out.println("Valeur min = " + liste.stream().mapToInt(Integer::intValue).min().orElse(-1));
//		System.out.println("Somme des valeurs = " + liste.stream().mapToInt(Integer::intValue).sum());
//		System.out.println("Moyenne = " + liste.stream().mapToInt(Integer::intValue).average().orElse(-1));

		LocalDateTime localDateTime = LocalDateTime.from(ZonedDateTime.now());
		System.out.println("Date et heure actuelle : " + localDateTime);

		LocalDate localDate = localDateTime.toLocalDate();
		System.out.println(localDate);

		String dateString = "2002-03-03";
		LocalDate dateFormString = localDate.parse(dateString);
		System.out.println(dateFormString);

		System.out.println(dateFormString.getYear());
		System.out.println(dateFormString.getDayOfYear());
		System.out.println(dateFormString.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE));

//		ZoneId.getAvailableZoneIds().forEach(System.out::println);
	}

}
