package ticket;

import person.Person;

public class CleaningTicket extends Ticket {
    private String type;  // Trash, Dirty Area

    public CleaningTicket(int id, String title, String desc, String location, Person assignedTo, String type) {
        super(id, title, desc, location, assignedTo);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        double score = 1;
        if(description.toLowerCase().contains("trash pile")) score += 5;
        return score;
    }
}