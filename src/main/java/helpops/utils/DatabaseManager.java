package helpops.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// v3 chaque appel obtient une connexion independante pour permettre
// les transactions isolees (SELECT FOR UPDATE, commit/rollback).
public class DatabaseManager {
    private static final String URL      = "jdbc:postgresql://localhost:5432/helpops";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "postgres";

    // donne NOUVELLE connexion a chaque appel
    // le code qui appelle doit la fermer via try-with-resources ou finally
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("[DB] Driver PostgreSQL introuvable.", e);
        }
    }
}
