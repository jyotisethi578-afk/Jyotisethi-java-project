import java.util.*;

abstract class ContactOperations {
    abstract void addContact();
    abstract void viewContacts();
    abstract void searchContact();
    abstract void updateContact();
    abstract void deleteContact();
}

class Contact {
    String name, phone, email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("----------------------");
    }
}

class ContactManager extends ContactOperations {
    ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact Added Successfully!");
    }

    void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No Contacts Found.");
            return;
        }

        for (Contact c : contacts) {
            c.display();
        }
    }

    void searchContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                c.display();
                return;
            }
        }
        System.out.println("Contact Not Found.");
    }

    void updateContact() {
        System.out.print("Enter Name to Update: ");
        String name = sc.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.print("Enter New Phone: ");
                c.phone = sc.nextLine();

                System.out.print("Enter New Email: ");
                c.email = sc.nextLine();

                System.out.println("Contact Updated!");
                return;
            }
        }
        System.out.println("Contact Not Found.");
    }

    void deleteContact() {
        System.out.print("Enter Name to Delete: ");
        String name = sc.nextLine();

        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            Contact c = it.next();
            if (c.name.equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Contact Deleted!");
                return;
            }
        }
        System.out.println("Contact Not Found.");
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n--- Contact Directory ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: cm.addContact(); break;
                case 2: cm.viewContacts(); break;
                case 3: cm.searchContact(); break;
                case 4: cm.updateContact(); break;
                case 5: cm.deleteContact(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 6);
    }
}