package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/mapage")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// pour indiquer le type de réponse
		response.setContentType("text/html");
		// indiquer encodage UTF-8 pour éviter pb avec les accents
		response.setCharacterEncoding("UTF-8");
//		PrintWriter out= response.getWriter();
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		out.println("Hello " + nom + " " + prenom);
		request.setAttribute("personneEnvoi", new Personne(2,"Cage","Nicolas"));
		request.setAttribute("maVille", "Marseille");
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
