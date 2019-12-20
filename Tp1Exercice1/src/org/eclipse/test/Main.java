package org.eclipse.test;

import org.eclipse.classes.Point;
import org.eclipse.classes.TroisPoints;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point a = new Point(1, 2);
		Point b = new Point(1, 4);
		Point c = new Point(1, 3);

		System.out.println("ab= " + a.calculerDistance(b));
		System.out.println("ac= " + a.calculerDistance(c));
		System.out.println("bc= " + b.calculerDistance(c));
		System.out.println("le milieu de a et b a pour coordonn�es " + a.calculerMilieu(b));
		System.out.println("le milieu de a et c a pour coordonn�es " + a.calculerMilieu(c));
		System.out.println("le milieu de b et c a pour coordonn�es " + b.calculerMilieu(c));

		TroisPoints troisPoints = new TroisPoints(a, b, c);

		System.out.println(troisPoints.testerAlignement());
		System.out.println(troisPoints.estTriangleEquilateral());

	}

}
