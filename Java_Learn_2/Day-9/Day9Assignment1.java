import java.util.*;

class Contact {
    String firstName, lastName, address, city, state;
    int zip;
    String phone, email;
}

public class Day9Assignment1 {

    static ArrayList<Contact> list = new ArrayList<>();

    public static void addContact() {
        Scanner sc = new Scanner(System.in);

        Contact c = new Contact();

        System.out.print("First Name: ");
        c.firstName = sc.nextLine();

        System.out.print("Last Name: ");
        c.lastName = sc.nextLine();

        System.out.print("City: ");
        c.city = sc.nextLine();

        list.add(c);

        System.out.println("Contact added!");
    }

    public static void editContact(String name) {
        Scanner sc = new Scanner(System.in);

        for (Contact c : list) {
            if (c.firstName.equals(name)) {

                System.out.print("Enter new city: ");
                c.city = sc.nextLine();

                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void deleteContact(String name) {

        Iterator<Contact> it = list.iterator();

        while (it.hasNext()) {
            Contact c = it.next();

            if (c.firstName.equals(name)) {
                it.remove();
                System.out.println("Contact deleted!");
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    public static void main(String[] args) {
        addContact();
        editContact("John");
        deleteContact("John");
    }
}