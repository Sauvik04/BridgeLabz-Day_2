import java.util.*;
import java.util.stream.Collectors;

// Contact Person Class
class ContactPerson1 {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private String email;

    // Constructor
    public ContactPerson1(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            int zip,
            String phoneNumber,
            String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getCity() {

        return city;
    }

    public String getState() {

        return state;
    }

    public int getZip() {

        return zip;
    }

    // Duplicate Checking
    @Override
    public boolean equals(Object obj) {

        if(this == obj) {

            return true;
        }

        if(obj == null ||
                getClass() != obj.getClass()) {

            return false;
        }

        ContactPerson1 person =
                (ContactPerson1) obj;

        return firstName.equalsIgnoreCase(
                person.firstName)
                &&
                lastName.equalsIgnoreCase(
                        person.lastName);
    }

    // toString Method
    @Override
    public String toString() {

        return firstName + " "
                + lastName + " | "
                + city + " | "
                + state + " | Zip: "
                + zip;
    }
}

// Address Book Logic
class AddressBookL {

    List<ContactPerson1> contactList =
            new ArrayList<>();

    // Add Contact
    public void addContact(
            ContactPerson1 contact) {

        boolean duplicate =
                contactList.stream()
                        .anyMatch(
                                person ->
                                        person.equals(contact));

        if(duplicate) {

            System.out.println(
                    "Duplicate Contact Found");
        }

        else {

            contactList.add(contact);

            System.out.println(
                    "Contact Added");
        }
    }

    // Display Contacts
    public void displayContacts() {

        contactList.forEach(System.out::println);
    }

    // Search By City
    public void searchByCity(String city) {

        List<ContactPerson1> result =
                contactList.stream()
                        .filter(
                                person ->
                                        person.getCity()
                                                .equalsIgnoreCase(city))
                        .collect(Collectors.toList());

        System.out.println(
                "\nPersons in City: " + city);

        result.forEach(System.out::println);
    }

    // Search By State
    public void searchByState(String state) {

        List<ContactPerson1> result =
                contactList.stream()
                        .filter(
                                person ->
                                        person.getState()
                                                .equalsIgnoreCase(state))
                        .collect(Collectors.toList());

        System.out.println(
                "\nPersons in State: " + state);

        result.forEach(System.out::println);
    }

    // Count By City
    public void countByCity(String city) {

        long count =
                contactList.stream()
                        .filter(
                                person ->
                                        person.getCity()
                                                .equalsIgnoreCase(city))
                        .count();

        System.out.println(
                "\nCount in "
                        + city + " = "
                        + count);
    }

    // Count By State
    public void countByState(String state) {

        long count =
                contactList.stream()
                        .filter(
                                person ->
                                        person.getState()
                                                .equalsIgnoreCase(state))
                        .count();

        System.out.println(
                "\nCount in "
                        + state + " = "
                        + count);
    }

    // Sort By Name
    public void sortByName() {

        System.out.println(
                "\nSorted By Name:");

        contactList.stream()
                .sorted(
                        Comparator.comparing(
                                person ->
                                        (person.getFirstName()
                                                + person.getLastName())
                                                .toLowerCase()))
                .forEach(System.out::println);
    }

    // Sort By City
    public void sortByCity() {

        System.out.println(
                "\nSorted By City:");

        contactList.stream()
                .sorted(
                        Comparator.comparing(
                                ContactPerson1::getCity))
                .forEach(System.out::println);
    }

    // Sort By State
    public void sortByState() {

        System.out.println(
                "\nSorted By State:");

        contactList.stream()
                .sorted(
                        Comparator.comparing(
                                ContactPerson1::getState))
                .forEach(System.out::println);
    }

    // Sort By Zip
    public void sortByZip() {

        System.out.println(
                "\nSorted By Zip:");

        contactList.stream()
                .sorted(
                        Comparator.comparingInt(
                                ContactPerson1::getZip))
                .forEach(System.out::println);
    }
}

// Main Class
public class Day24Assignment {

    public static void main(String[] args) {

        System.out.println(
                "Welcome To Address Book");

        AddressBookL book =
                new AddressBookL();

        // Contacts
        ContactPerson1 p1 =
                new ContactPerson1(
                        "John",
                        "Doe",
                        "Main Street",
                        "Chennai",
                        "Tamil Nadu",
                        600001,
                        "9876543210",
                        "john@gmail.com");

        ContactPerson1 p2 =
                new ContactPerson1(
                        "Alice",
                        "Smith",
                        "2nd Street",
                        "Bangalore",
                        "Karnataka",
                        560001,
                        "9999999999",
                        "alice@gmail.com");

        ContactPerson1 p3 =
                new ContactPerson1(
                        "Bob",
                        "Marley",
                        "3rd Street",
                        "Chennai",
                        "Tamil Nadu",
                        600002,
                        "8888888888",
                        "bob@gmail.com");

        // Duplicate
        ContactPerson1 p4 =
                new ContactPerson1(
                        "John",
                        "Doe",
                        "XYZ",
                        "Delhi",
                        "Delhi",
                        110001,
                        "7777777777",
                        "duplicate@gmail.com");

        // Add Contacts
        book.addContact(p1);
        book.addContact(p2);
        book.addContact(p3);
        book.addContact(p4);

        // Display
        System.out.println(
                "\nAll Contacts:");

        book.displayContacts();

        // Search
        book.searchByCity("Chennai");
        book.searchByState("Tamil Nadu");

        // Count
        book.countByCity("Chennai");
        book.countByState("Tamil Nadu");

        // Sort
        book.sortByName();
        book.sortByCity();
        book.sortByState();
        book.sortByZip();
    }
}