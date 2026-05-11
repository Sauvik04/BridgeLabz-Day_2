import java.util.*;
import java.util.stream.Collectors;

class ContactPerson { // Renamed to avoid potential naming conflicts
    private String firstName, lastName, address, city, state, email;
    private int zip;
    private long phoneNumber;
    public ContactPerson(String firstName, String lastName, String address, String city,
                         String state, int zip, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }
    public String getState() { return state; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactPerson)) return false;
        ContactPerson contact = (ContactPerson) o;
        return firstName.equalsIgnoreCase(contact.firstName) &&
                lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + city + ")";
    }
}
class AddressBookLogic {
    private List<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contact) {
        if (contactList.stream().anyMatch(c -> c.equals(contact))) {
            System.out.println("Duplicate entry found.");
        } else {
            contactList.add(contact);
        }
    }

    public List<ContactPerson> getContactList() {
        return contactList;
    }

    public void sortByPersonName() {
        contactList.stream()
                .sorted(Comparator.comparing(c -> (c.getFirstName() + c.getLastName()).toLowerCase()))
                .forEach(System.out::println);
    }
}

public class Day22Assignment1 {
    private Map<String, AddressBookLogic> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        Day22Assignment1 system = new Day22Assignment1();
        AddressBookLogic myBook = new AddressBookLogic();
        ContactPerson person1 = new ContactPerson("John", "Doe", "Main St", "New York", "NY", 10001, 1234567890L, "john@test.com");
        myBook.addContact(person1);
        System.out.println("Sorted Contacts:");
        myBook.sortByPersonName();
    }
}