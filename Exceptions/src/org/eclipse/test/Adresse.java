package org.eclipse.test;

import org.eclipse.exceptions.AdresseExceptions;
import org.eclipse.exceptions.IncorrectCodePostalException;
import org.eclipse.exceptions.IncorrectStreetNameException;

public class Adresse {

	private String rue;
	private String ville;
	private String codePostal;

	public Adresse(String rue, String ville, String codePostal) throws AdresseExceptions {
		if (!rue.equals(rue.toUpperCase()) && codePostal.length() != 5)
			throw new AdresseExceptions(codePostal, rue);
		setRue(rue);
		setCodePostal(codePostal);
		this.ville = ville;

	}

	public Adresse() {
		super();
	}

	public String getRue() {
		return rue;
	}

//	public void setRue(String rue) throws AdresseExceptions {
//		if (!rue.equals(rue.toUpperCase()))
//			throw new AdresseExceptions(rue);
//		else
//			this.rue = rue;
//	}

	public void setRue(String rue) throws AdresseExceptions {
		if (!rue.equals(rue.toUpperCase()))
			throw new AdresseExceptions(1, rue);
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

//	public void setCodePostal(String codePostal) throws IncorrectCodePostalException {
//		if (codePostal.length() != 5)
//			throw new IncorrectCodePostalException(codePostal);
//		else
//			this.codePostal = codePostal;
//	}

	public void setCodePostal(String codePostal) throws AdresseExceptions {
		if (codePostal.length() != 5)
			throw new AdresseExceptions(0, codePostal);
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}

}
