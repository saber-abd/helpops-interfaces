package helpops.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// v3 statistiques fonctionnement plateforme
public class Statistiques implements Serializable {
    private static final long serialVersionUID = 1L;

    private int totalTickets;
    private int ticketsResolus;
    private Map<String, Integer> ticketsParEtat;
    private double tempsMoyenResolutionHeures;
    private Map<String, Integer> ticketsParAgent;
    private double tauxPression; // tickets / agent actif / jour

    public Statistiques() {
        ticketsParEtat  = new HashMap<>();
        ticketsParAgent = new HashMap<>();
    }

    // getters
    public int getTotalTickets()                          { return totalTickets; }
    public int getTicketsResolus()                        { return ticketsResolus; }
    public Map<String, Integer> getTicketsParEtat()       { return ticketsParEtat; }
    public double getTempsMoyenResolutionHeures()         { return tempsMoyenResolutionHeures; }
    public Map<String, Integer> getTicketsParAgent()      { return ticketsParAgent; }
    public double getTauxPression()                       { return tauxPression; }

    // setters
    public void setTotalTickets(int v)                          { totalTickets = v; }
    public void setTicketsResolus(int v)                        { ticketsResolus = v; }
    public void setTicketsParEtat(Map<String, Integer> v)       { ticketsParEtat = v; }
    public void setTempsMoyenResolutionHeures(double v)         { tempsMoyenResolutionHeures = v; }
    public void setTicketsParAgent(Map<String, Integer> v)      { ticketsParAgent = v; }
    public void setTauxPression(double v)                       { tauxPression = v; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== STATISTIQUES HELP'OPS ===\n");
        sb.append(String.format("Total des tickets         : %d%n", totalTickets));
        sb.append(String.format("Tickets resolus           : %d%n", ticketsResolus));
        sb.append("Tickets par etat          :\n");
        ticketsParEtat.forEach((e, c) -> sb.append(String.format("  %-10s : %d%n", e, c)));
        sb.append(String.format("Temps moyen de resolution : %.1f secondes%n", tempsMoyenResolutionHeures));
        sb.append("Tickets par agent         :\n");
        if (ticketsParAgent.isEmpty()) {
            sb.append("  (aucun agent actif)\n");
        } else {
            ticketsParAgent.forEach((a, c) -> sb.append(String.format("  %-20s : %d%n", a, c)));
        }
        sb.append(String.format("Taux de pression          : %.2f ticket/agent/jour%n", tauxPression));
        return sb.toString();
    }
}
