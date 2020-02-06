package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		String nom = request.getParameter("nom");
		String pwd = request.getParameter("pwd");
		PersonneDaoImpl daop = new PersonneDaoImpl();
		Personne authPersonne = daop.findByNomAndPrenom(nom, pwd);
		if (authPersonne != null) {
			HttpSession session = request.getSession();
			int id = authPersonne.getId();
			session.setAttribute("id", id);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", pwd);
			session.setAttribute("sexe", authPersonne.getSexe());
			String typeF = "Madame";
			String typeM = "Monsieur";
			switch (authPersonne.getSexe()) {
			case ('f'):
				session.setAttribute("type", typeF);
				break;
			case ('m'):
				session.setAttribute("type", typeM);
				break;
			}
			response.sendRedirect("gestionCompte");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
