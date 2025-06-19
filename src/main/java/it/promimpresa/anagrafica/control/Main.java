package it.promimpresa.anagrafica.control;

import java.time.LocalDateTime;


import it.promimpresa.*;
import it.promimpresa.anagrafica.model.Persona;
import it.promimpresa.anagrafica.persistence.impl.*;
import it.promimpresa.anagrafica.persistence.DAOException;
import it.promimpresa.anagrafica.persistence.PersonaDAO;
import it.promimpresa.anagrafica.persistence.impl.PersonaDAOImpl;


public class Main {
	private static PersonaDAO personaDAO = new PersonaDAOImpl();

	public static void main(String[] args) {
		save();
		// update();
		findById(2);
		// findAll();
		// findByNome("Ylenia");
		// findByCognome("Lombardi");
		// count();
		findByCF("CF3");
		// delete(4);
		// findByAnno("1990");
	}

	private static void save() {
		try {
			System.out.println("=== Save ===");
			Persona persona = new Persona();
			persona.setCF("CF" + System.currentTimeMillis());
			persona.setNome("Fortunato");
			persona.setCognome("Fortunino");
			persona.setData_nascita(LocalDateTime.of(2000, 1, 1, 0, 0, 1));
			personaDAO.save(persona);
		} catch (DAOException e) {
			e.printStackTrace(); // invece di solo il messaggio generico

			System.out.println("Ops...si è verificato un errore!");
		}

	}

	private static Persona findById(int id) {
		Persona persona = null;
		try {
			System.out.println("=== Find By Id ===");
			persona = (personaDAO).findById(id);
			System.out.println(persona);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persona;
	}

	private static Persona findByCF(String CF) {
		Persona persona = null;
		try {
			System.out.println("=== Find By CF ===");
			persona = personaDAO.findByCF(CF);
			System.out.println(persona);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persona;
	}

}
