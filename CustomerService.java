package srcs;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Ticket> tickets = new ArrayList<>();
    private int ticketCounter = 1;

    public void createTicket(String customerName, String issueType, String description) {
        Ticket ticket = new Ticket(ticketCounter++, customerName, issueType, description);
        tickets.add(ticket);
        System.out.println("Ticket created successfully!");
    }

    public void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void assignStaff(int ticketId, String staffName) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                ticket.setAssignedStaff(staffName);
                ticket.setStatus("In Progress");
                System.out.println("Staff assigned successfully.");
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    public void closeTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                ticket.setStatus("Closed");
                System.out.println("Ticket closed successfully.");
                return;
            }
        }
        System.out.println("Ticket not found.");
    }
}
