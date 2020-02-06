package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.dao.AdresseDaoImpl;
import org.eclipse.model.Adresse;

/**
 * Servlet implementation class DetailsAdresse
 */
@WebServlet("/detailsAdresse")
public class DetailsAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsAdresse() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsAdresse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choix = request.getParameter("choix");
		HttpSession session = request.getSession();
		Adresse adresse = (Adresse) session.getAttribute("adresseToUpdate");

		if (choix.equals("enregistrer")) {
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			if (!rue.isEmpty())
				adresse.setRue(rue);
			if (!codePostal.isEmpty())
				adresse.setCodePostal(codePostal);
			if (!ville.isEmpty())
				adresse.setVille(ville);
			AdresseDaoImpl daoa = new AdresseDaoImpl();
			daoa.update(adresse);
			response.sendRedirect("gestionAdresse");
		}

		else if (choix.equals("deconnexion"))
			response.sendRedirect("deconnexion");
	}

}
