package org.eclipse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

/**
 * Servlet implementation class AjoutPersonneServlet
 */
@WebServlet("/ajoutPersonne")
public class AjoutPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPersonneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean test = true;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		try {
			verifChaine(nom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("nomIncorrect", e.getMessage());
			test = false;
		}

		try {
			verifChaine(prenom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("prenomIncorrect", e.getMessage());
			test = false;
		}

		if (test) {
			String nomAdd = request.getParameter("nom");
			String prenomAdd = request.getParameter("prenom");
			Personne personne = new Personne(nomAdd, prenomAdd);
			PersonneDaoImpl daop = new PersonneDaoImpl();
			Personne insertedPersonne = daop.save(personne);
			request.setAttribute("personne", insertedPersonne);
			this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
		}

		else {
			request.setAttribute("nomSaisi", nom);
			request.setAttribute("prenomSaisi", prenom);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(request, response);
		}

	}

	public void verifChaine(String s) throws Exception {
		if (s == null || s.length() < 2)
			throw new Exception("La chaîne doit comporter au moins deux caractères.");
		char c = s.charAt(0);
		if (!(c >= 'A' && c <= 'Z'))
			throw new Exception("La chaîne doit commencer pas une lettre majuscule.");
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z'))
				throw new Exception("La chaîne ne peut comporter que des lettres.");
		}
	}

}
