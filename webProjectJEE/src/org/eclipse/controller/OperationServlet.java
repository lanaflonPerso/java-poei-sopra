package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/operation")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// pour indiquer le type de réponse
		response.setContentType("text/html");
		// indiquer encodage UTF-8 pour éviter pb avec les accents
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String var1 = request.getParameter("var1");
		String var2 = request.getParameter("var2");
		String op = request.getParameter("op");
		
		if (request.getParameter("var1") != null && request.getParameter("var2") != null
				&& request.getParameter("op") != null) {
			Integer x = Integer.parseInt(var1);
			Integer y = Integer.parseInt(var2);
			Integer result = 0;
			if (op.equals("plus")) {
				result = x + y;
			} else if (op.equals("moins")) {
				result = x - y;
			} else if (op.equals("fois")) {
				result = x * y;
			} else if (op.equals("div")) {
				result = x / y;
			}

			out.println(var1 + " " + op + " " + var2 + " = " + result);
		} else {
			out.println("Spécifiez des valeurs dans l'URL");
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
