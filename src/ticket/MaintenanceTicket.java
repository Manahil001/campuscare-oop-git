package ticket;

import person.Person;

public class MaintenanceTicket extends Ticket {
    private String type;  // Chair, Desk, Window, Board

    public MaintenanceTicket(int id, String title, String desc, String location, Person assignedTo, String type) {
        super(id, title, desc, location, assignedTo);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        double score = 1;
        if(location.toLowerCase().contains("lab")) score += 5;
        if(type.equalsIgnoreCase("Board")) score += 2;
        return score;
    }
}