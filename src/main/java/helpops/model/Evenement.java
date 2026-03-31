package helpops.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;      // "CREATION", "PRISE_EN_CHARGE", "RESOLUTION"
    private int ticketId;
    private String message;
    private LocalDateTime date;

    public Evenement(String type, int ticketId, String message) {
        this.type = type;
        this.ticketId = ticketId;
        this.message = message;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("[%s] %-15s | Ticket #%d | %s",
                date.format(dtf), type, ticketId, message);
    }
}