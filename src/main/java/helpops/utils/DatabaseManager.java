package helpops.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Informations de connexion
    private static final String URL = "jdbc:postgresql://localhost:5432/helpops_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection = null;

    // Retourne une connexion unique à la base de données
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Chargement du driver
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("[DB] Connexion à PostgreSQL réussie.");
            } catch (ClassNotFoundException e) {
                throw new SQLException("[DB] Driver PostgreSQL introuvable.", e);
            }
        }
        return connection;
    }

    //Fermeture de la connexion
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("[DB] Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}