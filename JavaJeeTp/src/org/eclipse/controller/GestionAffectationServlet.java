package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class GestionAffectationServlet
 */
@WebServlet("/gestionAffectation")
public class GestionAffectationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAffectationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		PersonneDaoImpl daop = new PersonneDaoImpl();
		AdresseDaoImpl daoa = new AdresseDaoImpl();
		Personne sessionPersonne = daop.findById((int)session.getAttribute("id"));
		session.setAttribute("sessionPersonne", sessionPersonne);
		String choix = request.getParameter("choix");
		ArrayList<Adresse> sessionAdresse = daoa.findByIdPersonne(sessionPersonne.getId());
		ArrayList<Adresse> adressesNotSession = daoa.findByIdPersonneNotEqual(sessionPersonne.getId());
		session.setAttribute("adresses", sessionAdresse);
		session.setAttribute("adressesNotSession", adressesNotSession);
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestionAffectation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		PersonneDaoImpl daop = new PersonneDaoImpl();
		AdresseDaoImpl daoa = new AdresseDaoImpl();
		Personne sessionPersonne = daop.findById((int)session.getAttribute("id"));
		session.setAttribute("sessionPersonne", sessionPersonne);
		String choix = request.getParameter("choix");
		ArrayList<Adresse> sessionAdresse = daoa.findByIdPersonne(sessionPersonne.getId());
		ArrayList<Adresse> adressesNotSession = daoa.findByIdPersonneNotEqual(sessionPersonne.getId());
		session.setAttribute("adresses", sessionAdresse);
		session.setAttribute("adressesNotSession", adressesNotSession);

		
		if (choix.equals("nouvelleAdresse")) {
			Adresse adresse=new Adresse();
			adresse.setRue(request.getParameter("rue"));
			adresse.setCodePostal(request.getParameter("codePostal"));
			adresse.setVille(request.getParameter("ville"));
			adresse.setPersonne(sessionPersonne);
			daoa.save(adresse);
			response.sendRedirect("gestionAffectation");			
		}
		
		else if (choix.equals("dissocier")) {
			int idDiss = Integer.parseInt(request.getParameter("idDiss"));
			Adresse adresseDiss = daoa.findById(idDiss);
			adresseDiss.setPersonne(null);
			daoa.updatePersonne(adresseDiss);
			response.sendRedirect("gestionAffectation");
		}
		
		else if (choix.equals("associer") ) {
			int idAss = Integer.parseInt(request.getParameter("idAss"));
			Adresse adresseAss=daoa.findById(idAss);
			adresseAss.setPersonne(sessionPersonne);
			daoa.updatePersonne(adresseAss);
			response.sendRedirect("gestionAffectation");
			
			
		}
		else if (choix.equals("gestionCompte")) {
			response.sendRedirect("gestionCompte");
		}
		
		else if (choix.equals("gestionAdresse")) {
			response.sendRedirect("gestionAdresse");
		}
		
	}
	

}
