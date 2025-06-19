package it.promimpresa.anagrafica.control;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.time.LocalDateTime;

import java.util.Enumeration;

import it.promimpresa.anagrafica.model.Persona;

import it.promimpresa.anagrafica.persistence.DAOException;

import it.promimpresa.anagrafica.persistence.impl.PersonaDAOImpl;

/**
 * 
 * 
 * 
 * Servlet implementation class Salva
 * 
 */

@WebServlet("/salva")

public class Salva extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static PersonaDAOImpl personaDAO = new PersonaDAOImpl();

	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public Salva() {
		super();
	} // TODO Auto-generated constructor stub }

	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * 
	 *      response)
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

// request.getMethod()

		response.getWriter().append(" - Method : " + request.getMethod());

// request.getContexPath()

		response.getWriter().append(" - ContextPath : " + request.getContextPath() + "\n");

// request.getHeader()

		response.getWriter().append(" - getHeader : " + request.getHeader("user-agent") + "\n");

// request.getHeaderName()

		Enumeration<String> en = request.getHeaderNames();

		while (en.hasMoreElements()) {

			String element = en.nextElement();

			response.getWriter().append(" - " + element + ": " + request.getHeader(element) + "\n");

		}

// request.getParameter() - restituisce il valore del parametro o inviati in

// query string

// nel caso di chiamate get o inviati dal body nel caso di chiamate post

		response.getWriter().append(" - getParameter : " + request.getParameter("pagina"));

	}

	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * 
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String codiceFiscale = request.getParameter("codiceFiscale");

		String nome = request.getParameter("name");

		String cognome = request.getParameter("surname");

		String dataNascita = request.getParameter("dataNascita");

		try {

			System.out.println("=== Save ===");

			Persona persona = new Persona();

			persona.setCF(codiceFiscale);

			persona.setNome(nome);

			persona.setCognome(cognome);

			persona.setData_nascita(LocalDateTime.parse(dataNascita));

			personaDAO.save(persona);

		} catch (DAOException e) {

			System.out.println("Ops...si è verificato un errore!");

		}
	}

}
