package ticket;

import person.Person;

public abstract class Ticket {
    public int ticketId;
    protected String title;
    protected String description;
    protected String location;
    protected String status;
    protected Person assignedTo;

    public Ticket(int ticketId, String title, String description, String location, Person assignedTo) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = "New";
        this.assignedTo = assignedTo;
    }

    public abstract double priorityScore();

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    public String getSummary() {
        return "Ticket#" + ticketId + " [" + this.getClass().getSimpleName() + "] Status: " + status;
    }
}