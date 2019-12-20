package org.eclipse.classes;


public class TroisPoints {
	private Point premier;
	private Point deuxieme;
	private Point troisieme;

	public TroisPoints(Point premier, Point deuxieme, Point troisieme) {
		super();
		this.premier = premier;
		this.deuxieme = deuxieme;
		this.troisieme = troisieme;
	}

	public TroisPoints() {
		super();
	}

	public Point getPremier() {
		return premier;
	}

	public void setPremier(Point premier) {
		this.premier = premier;
	}

	public Point getDeuxieme() {
		return deuxieme;
	}

	public void setDeuxieme(Point deuxieme) {
		this.deuxieme = deuxieme;
	}

	public Point getTroisieme() {
		return troisieme;
	}

	public void setTroisieme(Point troisieme) {
		this.troisieme = troisieme;
	}

	public boolean testerAlignement() {
		double ab = this.premier.calculerDistance(this.deuxieme);
		double ac = this.premier.calculerDistance(this.troisieme);
		double bc = this.deuxieme.calculerDistance(this.troisieme);

		if ((ab == ac + bc) || (ac == ab + bc) || (bc == ac + ab)) {
			return true;
		} else
			return false;
	}

	public boolean estTriangleEquilateral() {
		double ab = this.premier.calculerDistance(this.deuxieme);
		double ac = this.premier.calculerDistance(this.troisieme);
		double bc = this.deuxieme.calculerDistance(this.troisieme);

		if ((ab == ac) && (ab == bc))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "TroisPoints [premier=" + premier + ", deuxieme=" + deuxieme + ", troisieme=" + troisieme + "]";
	}

}
