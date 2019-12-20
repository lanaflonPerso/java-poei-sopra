package org.eclipse.classes;

public class Point {
	private int abs;
	private int ord;

	public Point(int abs, int ord) {
		super();
		this.abs = abs;
		this.ord = ord;
	}

	public Point() {
		super();
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public double calculerDistance(Point p) {
		return Math.sqrt(Math.pow(this.abs - p.abs, 2) + Math.pow(this.ord - p.ord, 2));
	}

	public Point calculerMilieu(Point p) {
		return new Point(
		(this.abs+p.abs)/2,
		(this.ord+p.ord)/2
		);
		
		
	}
	
	@Override
	public String toString() {
		return "Point [abs=" + abs + ", ord=" + ord + "]";
	}

}
