package helpops.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Base de donnee postgres
public class DatabaseManager {
    private static final String URL      = "jdbc:postgresql://localhost:5432/helpops";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("[DB] Driver PostgreSQL introuvable.", e);
        }
    }
}
