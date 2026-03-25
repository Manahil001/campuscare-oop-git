 CampusCare

CampusCare ek **console-based Java application** hai jo campus maintenance complaints ko manage karta hai. Ye project **Java OOP concepts** aur **Git workflow practice** ke liye design kiya gaya hai.

---

Features

- Person Management  
  - Student aur Staff ko add karna  
  - Private fields + validation (email must contain `@`)  

- Ticket Management  
  - MaintenanceTicket (Chair, Desk, Window, Board)  
  - CleaningTicket (Trash, Dirty Area)  
  - Tickets assign karna kisi Person ko  
  - Abstract class `Ticket` aur polymorphism ka use  

- Ticket Operations 
  - View all tickets (summary + priority score)  
  - Update ticket status (New → Assigned → Resolved)  

- OOP Concepts Used 
  - Encapsulation (private fields, getters/setters)  
  - Inheritance (Person → Student/Staff)  
  - Abstract classes & Polymorphism (Ticket → Maintenance/CleaningTicket)  

- **Git Features Practiced**  
  - Initialize repository, commit, push, pull  
  - Branch creation, merge, rebase, stash, revert  

---


1. Clone the repository:  
```bash
git clone https://github.com/Manahil001/campuscare-oop-git.git
