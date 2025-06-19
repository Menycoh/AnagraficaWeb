package it.promimpresa.anagrafica.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import it.promimpresa.anagrafica.persistence.impl.*;
import it.promimpresa.anagrafica.persistence.*;
import it.promimpresa.anagrafica.control.*;
import it.promimpresa.anagrafica.model.Persona;


public class PersonaDAOImpl implements PersonaDAO {

	public void save(Persona persona) throws DAOException {
	    String SQL = "INSERT INTO persona (CF, nome, cognome, data_nascita) VALUES (?, ?, ?, ?)";
	    
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet generateKeys = null;

	    try {
	        connection = DataSource.getConnection();
	        statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);  // ← Migliore pratica
	        statement.setString(1, persona.getCF());
	        statement.setString(2, persona.getNome());
	        statement.setString(3, persona.getCognome());
	        statement.setTimestamp(4, Timestamp.valueOf(persona.getData_nascita()));
	        statement.executeUpdate();

	        generateKeys = statement.getGeneratedKeys();
	        if (generateKeys.next()) {
	            persona.setId(generateKeys.getInt(1));
	        }

	    } catch (SQLException e) {
	        throw new DAOException("Errore durante il salvataggio della persona", e);
	    } finally {
	        DBUtil.close(generateKeys);  // ← AGGIUNTO
	        DBUtil.close(statement);
	        DBUtil.close(connection);
	    }
	}

	public Persona findById(int id) throws DAOException {
		String SQL = "SELECT * FROM persona WHERE id = ?";
		System.out.println(SQL);
		Persona persona = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persona;
	}

	@Override
	public void update(Persona persona) throws DAOException {
		String SQL = "UPDATE persona SET CF = ?,  nome = ? , cognome = ?, data_nascita = ? WHERE id = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, persona.getCF());
			statement.setString(2, persona.getNome());
			statement.setString(3, persona.getCognome());
			statement.setTimestamp(4, Timestamp.valueOf(persona.getData_nascita()));
			statement.setInt(5, persona.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
	}

	public Persona findByCF(String CF) throws DAOException {
		String SQL = "SELECT * FROM persona WHERE CF = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, CF);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persona;
	}

	public List<Persona> findAll() throws DAOException {
		List<Persona> persone = new ArrayList<>();
		String SQL = "SELECT * FROM persona";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
				persone.add(persona);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persone;
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
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

}
