package it.promimpresa.anagrafica.persistence;

import java.util.List;

import it.promimpresa.anagrafica.model.*;

public interface PersonaDAO {
	void save(Persona persona) throws DAOException;

	void update(Persona persona) throws DAOException;

	void delete(int id) throws DAOException;

	Persona findById(int id) throws DAOException;

	List<Persona> findAll() throws DAOException;

	Persona findByCF(String CF) throws DAOException;

	List<Persona> findByNome(String nome) throws DAOException;

	List<Persona> findByCognome(String cognome) throws DAOException;

	long count() throws DAOException;

	List<Persona> findByAnno(String annoNascita) throws DAOException;
}
