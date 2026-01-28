package srcs;

public class Ticket {

    private int ticketId;
    private String customerName;
    private String issueType;
    private String description;
    private String status;
    private String assignedStaff;

    public Ticket(int ticketId, String customerName, String issueType, String description) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issueType = issueType;
        this.description = description;
        this.status = "Open";
        this.assignedStaff = "Not Assigned";
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignedStaff(String assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                "\nCustomer Name: " + customerName +
                "\nIssue Type: " + issueType +
                "\nDescription: " + description +
                "\nStatus: " + status +
                "\nAssigned Staff: " + assignedStaff +
                "\n----------------------------";
    }
}
