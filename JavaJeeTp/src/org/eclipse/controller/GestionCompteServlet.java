package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

/**
 * Servlet implementation class GestionCompteServlet
 */
@WebServlet("/gestionCompte")
public class GestionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCompteServlet() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestionCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonneDaoImpl daop = new PersonneDaoImpl();
		HttpSession session = request.getSession();
		Personne sessionPersonne = daop.findById((Integer) session.getAttribute("id"));

		String choix = request.getParameter("choix");
		if (choix.equals("modifCompte")) {
			if (!request.getParameter("nom").isEmpty())
				sessionPersonne.setNom(request.getParameter("nom"));
			if (!request.getParameter("prenom").isEmpty())
				sessionPersonne.setPrenom(request.getParameter("prenom"));
			if (!request.getParameter("sexe").isEmpty())
				sessionPersonne.setSexe(request.getParameter("sexe").charAt(0));
			daop.update(sessionPersonne);
			session.setAttribute("nom", sessionPersonne.getNom());
			session.setAttribute("prenom", sessionPersonne.getPrenom());
			session.setAttribute("sexe", sessionPersonne.getSexe());
			String typeF = "Madame";
			String typeM = "Monsieur";

			switch (sessionPersonne.getSexe()) {
			case ('f'):
				session.setAttribute("type", typeF);
				break;
			case ('m'):
				session.setAttribute("type", typeM);
				break;
			}
			response.sendRedirect("gestionCompte");
		}

		else if (choix.equals("supprCompte")) {
			daop.remove(sessionPersonne);
			response.sendRedirect("index");
		}

		else if (choix.equals("gestionAdresse")) {
			response.sendRedirect("gestionAdresse");
		}
		
		else if (choix.equals("gestionAffectation")) {
			response.sendRedirect("gestionAffectation");
		}

	}

}
