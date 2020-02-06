package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

/**
 * Servlet implementation class modifPersonServlet
 */
@WebServlet("/modifPerson")
public class modifPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modifPersonServlet() {
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
		request.setAttribute("test", true);
		String mtd = request.getParameter("mtd");
		request.setAttribute("mtd", mtd);
		this.getServletContext().getRequestDispatcher("/WEB-INF/exModifPerson.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("test", false);
		String mtd = request.getParameter("mtd");
		PrintWriter out = response.getWriter();

		if (mtd.equals("add")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Personne personne = new Personne(nom, prenom);
			PersonneDaoImpl daop = new PersonneDaoImpl();
			Personne insertedPersonne = daop.save(personne);
			request.setAttribute("personne", insertedPersonne);
			out.print(insertedPersonne.getPrenom() + " " + insertedPersonne.getNom()
					+ " has been successfully added to our database");

		} else if (mtd.equals("edit")) {
			Integer num = Integer.parseInt(request.getParameter("num"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			PersonneDaoImpl daop = new PersonneDaoImpl();
			Personne updatedPerson = daop.findById(num);
			if (updatedPerson == null) {
				out.print("La personne n°" + num + " n'existe pas.");
			} else {
				updatedPerson.setNom(nom);
				updatedPerson.setPrenom(prenom);
				daop.update(updatedPerson);
				out.print("La personne n°" + updatedPerson.getNum() + " a bien été modifiée.");
			}
		}

		else if (mtd.equals("remove")) {
			Integer num = Integer.parseInt(request.getParameter("num"));
			PersonneDaoImpl daop = new PersonneDaoImpl();
			Personne removedPerson = daop.findById(num);
			if (removedPerson == null) {
				out.print("La personne n°" + num + " n'existe pas.");
			} else {
				daop.remove(removedPerson);
				out.print(removedPerson.getPrenom() + " " + removedPerson.getNom() + " a bien été supprimée.");
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/exModifPerson.jsp").forward(request, response);
	}

}
