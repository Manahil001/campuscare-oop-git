import person.*;
import ticket.*;
import java.util.*;

public class Main {
    static List<Person> persons = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int personIdCounter = 1;
    static int ticketIdCounter = 1;

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n--- CampusCare Menu ---");
            System.out.println("1. Add Person");
            System.out.println("2. Create Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");
            System.out.print("Select option: ");
            int option = sc.nextInt();
            sc.nextLine();  // consume newline

            switch(option) {
                case 1: addPerson(); break;
                case 2: createTicket(); break;
                case 3: viewTickets(); break;
                case 4: updateTicketStatus(); break;
                case 5: return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    static void addPerson() {
        System.out.print("Type (1=Student, 2=Staff): ");
        int type = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();

        if(type==1) {
            System.out.print("Program: "); String prog = sc.nextLine();
            System.out.print("Semester: "); int sem = sc.nextInt(); sc.nextLine();
            persons.add(new Student(personIdCounter++, name, email, prog, sem));
        } else {
            System.out.print("Department: "); String dept = sc.nextLine();
            persons.add(new Staff(personIdCounter++, name, email, dept));
        }
    }

    static void createTicket() {
        System.out.print("Ticket type (1=Maintenance, 2=Cleaning): ");
        int type = sc.nextInt(); sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Description: "); String desc = sc.nextLine();
        System.out.print("Location: "); String loc = sc.nextLine();
        System.out.print("Assign to Person ID: "); int pid = sc.nextInt(); sc.nextLine();
        Person assigned = persons.stream().filter(p->p.getId()==pid).findFirst().orElse(null);
        if(assigned==null){ System.out.println("Invalid Person ID"); return; }

        if(type==1) {
            System.out.print("Maintenance Type (Chair/Desk/Window/Board): "); String t = sc.nextLine();
            tickets.add(new MaintenanceTicket(ticketIdCounter++, title, desc, loc, assigned, t));
        } else {
            System.out.print("Cleaning Type (Trash/Dirty Area): "); String t = sc.nextLine();
            tickets.add(new CleaningTicket(ticketIdCounter++, title, desc, loc, assigned, t));
        }
    }

    static void viewTickets() {
        for(Ticket t: tickets) {
            System.out.println(t.getSummary() + " | Priority: " + t.priorityScore());
        }
    }

    static void updateTicketStatus() {
        System.out.print("Enter Ticket ID: "); int tid = sc.nextInt(); sc.nextLine();
        Ticket t = tickets.stream().filter(ticket->ticket.ticketId==tid).findFirst().orElse(null);
        if(t==null) { System.out.println("Invalid Ticket ID"); return; }

        System.out.print("New Status (New/Assigned/Resolved): "); String status = sc.nextLine();
        t.setStatus(status);
    }
}