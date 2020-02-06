package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;

/**
 * Servlet implementation class ExerciceServlet
 */
@WebServlet("/ExerciceServlet")
public class ExerciceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// pour indiquer le type de réponse
		response.setContentType("text/html");
		// indiquer encodage UTF-8 pour éviter pb avec les accents
		response.setCharacterEncoding("UTF-8");
		
		Personne personne1 = new Personne(1, "Wick", "John");
		Personne personne2 = new Personne(2, "Cage", "Nicolas");
		Personne personne3 = new Personne(3, "Doe", "Joe");
		Personne personne4 = new Personne(4, "Green", "Bob");
		
		String idString = request.getParameter("id");
		
		List<Personne> personnes = List.of(personne1, personne2, personne3, personne4);
	
		
		request.setAttribute("personne1", personne1);
		request.setAttribute("personne2", personne2);
		request.setAttribute("personne3", personne3);
		request.setAttribute("personne4", personne4);
		request.setAttribute("id", idString);
		request.setAttribute("personnes", personnes);
		
		
		ArrayList<String> sports = new ArrayList<String>();
		sports.add("football");
		sports.add("tennis");
		sports.add("rugby");
		sports.add("basketball");
		request.setAttribute("sports", sports);		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueExercice.jsp").forward(request, response);
		
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
