package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.dao.AdresseDaoImpl;
import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Adresse;
import org.eclipse.model.Personne;

/**
 * Servlet implementation class GestionAdresseServlet
 */
@WebServlet("/gestionAdresse")
public class GestionAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionAdresseServlet() {
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

		HttpSession session = request.getSession();
		PersonneDaoImpl daop = new PersonneDaoImpl();
		AdresseDaoImpl daoa = new AdresseDaoImpl();
		Personne sessionPersonne = daop.findById((int) session.getAttribute("id"));
		session.setAttribute("sessionPersonne", sessionPersonne);
		String choix = request.getParameter("choix");
		ArrayList<Adresse> sessionAdresse = daoa.findByIdPersonne(sessionPersonne.getId());
		session.setAttribute("adresses", sessionAdresse);
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestionAdresse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PersonneDaoImpl daop = new PersonneDaoImpl();
		AdresseDaoImpl daoa = new AdresseDaoImpl();
		Personne sessionPersonne = daop.findById((int) session.getAttribute("id"));
		session.setAttribute("sessionPersonne", sessionPersonne);
		String choix = request.getParameter("choix");

		if (choix.equals("supprimer")) {
			int id = Integer.parseInt(request.getParameter("idAd"));
			Adresse adresse = daoa.findById(id);
			daoa.remove(adresse);
			response.sendRedirect("gestionAdresse");
		}
		
		if (choix.equals("modifier")) {
			int id = Integer.parseInt(request.getParameter("idAd"));
			Adresse adresse = daoa.findById(id);
			session.setAttribute("adresseToUpdate", adresse);
			response.sendRedirect("detailsAdresse");
		}
		
	}

}
