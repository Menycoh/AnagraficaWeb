package it.promimpresa.anagrafica.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DataSource {
    // Aggiunti parametri per evitare problemi di connessione con le nuove versioni di MySQL
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/anagrafica_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Assicurati che questa sia la password corretta
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver JDBC caricato con successo.");
        } catch (ClassNotFoundException e) {
            System.err.println("Errore: Impossibile caricare il driver JDBC. Assicurati che il JAR di MySQL Connector/J sia nel classpath.");
            e.printStackTrace();
            // Lancia un'eccezione in runtime per indicare un errore critico di configurazione
            throw new RuntimeException("Impossibile caricare il driver JDBC.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
