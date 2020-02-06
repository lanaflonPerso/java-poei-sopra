package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;

/**
 * Servlet implementation class JstlServlet
 */
@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Personne personne1 = new Personne(1, "Wick", "John");
		Personne personne2 = new Personne(2, "Cage", "Nicolas");
		Personne personne3 = new Personne(3, "Doe", "John");
		Personne personne4 = new Personne(4, "Green", "Bob");
		List<Personne> personnes = List.of(personne1, personne2, personne3, personne4);
		request.setAttribute("personnes", personnes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueJstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
