package helpops.utils;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class ConsoleUtils {

    public static String hacher(String motDePasse) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(motDePasse.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erreur de hachage", e);
        }
    }

    public static String lireMotDePasse(java.util.Scanner scanner) {
        Console console = System.console();
        if (console != null) {
            char[] passwordChars = console.readPassword("Mot de passe : ");
            return new String(passwordChars);
        } else {
            System.out.print("Mot de passe : ");
            return scanner.nextLine().trim();
        }
    }
}