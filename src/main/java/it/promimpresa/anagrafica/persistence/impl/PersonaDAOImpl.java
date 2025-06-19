package it.promimpresa.anagrafica.persistence.impl;

import it.promimpresa.anagrafica.model.Persona;
import it.promimpresa.anagrafica.persistence.DAOException;
import it.promimpresa.anagrafica.persistence.PersonaDAO; // Assicurati di avere un'interfaccia PersonaDAO
import it.promimpresa.anagrafica.persistence.DataSource; // Importa la tua classe DataSource

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Per convertire LocalDateTime in Timestamp per il database
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO { // Assicurati che implementi PersonaDAO

	// Costruttore vuoto, non serve più caricare il driver qui, lo fa DataSource
	public PersonaDAOImpl() {
		// Il driver viene caricato nel blocco statico di DataSource all'avvio.
	}

	@Override
	public void save(Persona persona) throws DAOException {
		// Query SQL per inserire una nuova persona.
		// Assicurati che i nomi delle colonne corrispondano al tuo schema del database.
		// Esempio: CF, nome, cognome, data_nascita
		String sql = "INSERT INTO persone (CF, nome, cognome, data_nascita) VALUES (?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DataSource.getConnection(); // Ottiene una connessione dal tuo DataSource
			ps = connection.prepareStatement(sql);

			// Imposta i parametri della query
			ps.setString(1, persona.getCF());
			ps.setString(2, persona.getNome());
			ps.setString(3, persona.getCognome());

			// Converte LocalDateTime in Timestamp per il database
			if (persona.getData_nascita() != null) {
				ps.setTimestamp(4, Timestamp.valueOf(persona.getData_nascita()));
			} else {
				ps.setNull(4, java.sql.Types.TIMESTAMP); // Gestisce il caso di data nulla
			}

			// Esegue la query
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected == 0) {
				throw new DAOException("Salvataggio persona fallito, nessuna riga interessata.");
			}
			System.out.println("Persona salvata nel DB con CF: " + persona.getCF());

		} catch (SQLException e) {
			// Incapsula SQLException in una DAOException personalizzata
			throw new DAOException("Errore durante il salvataggio della persona nel database: " + e.getMessage(), e);
		} finally {
			// Chiude le risorse in ordine inverso rispetto a come sono state aperte
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.err.println("Errore nella chiusura del PreparedStatement: " + e.getMessage());
			}
			DataSource.closeConnection(connection); // Chiude la connessione usando il DataSource
		}
	}

	@Override
	public void update(Persona persona) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona findById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findByCF(String CF) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByCognome(String cognome) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Persona> findByAnno(String annoNascita) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	// Aggiungi qui altri metodi come findById, findAll, update, delete ecc. se
	// necessari
	// Esempio di un metodo findById:
	/*
	 * @Override public Persona findById(String cf) throws DAOException { String sql
	 * = "SELECT CF, nome, cognome, data_nascita FROM persone WHERE CF = ?";
	 * Connection connection = null; PreparedStatement ps = null; ResultSet rs =
	 * null; Persona persona = null;
	 * 
	 * try { connection = DataSource.getConnection(); ps =
	 * connection.prepareStatement(sql); ps.setString(1, cf); rs =
	 * ps.executeQuery();
	 * 
	 * if (rs.next()) { persona = new Persona(); persona.setCF(rs.getString("CF"));
	 * persona.setNome(rs.getString("nome"));
	 * persona.setCognome(rs.getString("cognome")); // Converte Timestamp del
	 * database in LocalDateTime Timestamp ts = rs.getTimestamp("data_nascita"); if
	 * (ts != null) { persona.setData_nascita(ts.toLocalDateTime()); } } } catch
	 * (SQLException e) { throw new
	 * DAOException("Errore durante la ricerca della persona per CF: " +
	 * e.getMessage(), e); } finally { try { if (rs != null) rs.close(); if (ps !=
	 * null) ps.close(); } catch (SQLException e) {
	 * System.err.println("Errore nella chiusura delle risorse: " + e.getMessage());
	 * } DataSource.closeConnection(connection); } return persona; }
	 */
}