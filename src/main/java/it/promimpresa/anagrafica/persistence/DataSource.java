package it.promimpresa.anagrafica.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	// Parametri di connessione al database
	private static final String DB_URL = "jdbc:mysql://localhost:3306/anagrafica_db"; // Sostituisci "anagrafica_db" con
																						// il nome del tuo database
	private static final String DB_USER = "root"; // Sostituisci con il tuo utente del database
	private static final String DB_PASSWORD = "password"; // Sostituisci con la tua password del database
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver per MySQL 8+

	// Blocco statico per caricare il driver una sola volta all'avvio
	// dell'applicazione
	static {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver JDBC caricato con successo: " + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Errore: Impossibile caricare il driver JDBC: " + JDBC_DRIVER);
			e.printStackTrace();
			// Puoi anche lanciare una RuntimeException qui per bloccare l'applicazione se
			// il driver è essenziale
			throw new RuntimeException("Impossibile caricare il driver JDBC: " + JDBC_DRIVER, e);
		}
	}

	/**
	 * Restituisce una nuova connessione al database.
	 * 
	 * @return Connection La connessione al database.
	 * @throws SQLException Se si verifica un errore durante la connessione.
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	/**
	 * Chiude una connessione al database.
	 * 
	 * @param connection La connessione da chiudere.
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Errore durante la chiusura della connessione: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}