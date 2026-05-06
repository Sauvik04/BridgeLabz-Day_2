public class Day19Assignment1 {

    public static void main(String[] args) {

        String firstName = "Jhingur";
        String lastName = "Kumar";
        String email = "abc.100@yahoo.com";
        String mobile = "91 9919819801";
        String password = "Password1@";

        boolean first =
                firstName.matches("[A-Z][a-z]{2,}");

        boolean last =
                lastName.matches("[A-Z][a-z]{2,}");

        boolean mail =
                email.matches(
                        "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$"
                );

        boolean phone =
                mobile.matches("^[0-9]{2}\\s[0-9]{10}$");

        boolean pass =
                password.matches(
                        "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$"
                );

        if (first && last && mail && phone && pass) {
            System.out.println("Valid User Details");
        } else {
            System.out.println("Invalid User Details");
        }
    }
}