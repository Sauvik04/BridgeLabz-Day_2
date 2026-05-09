import java.util.regex.Pattern;

class InvalidUserDetailsException extends Exception {

    public InvalidUserDetailsException(String message) {
        super(message);
    }
}
class UserRegistration {

    public void validateFirstName(String firstName)
            throws InvalidUserDetailsException {

        if (!Pattern.matches("[A-Z][a-z]{2,}", firstName)) {

            throw new InvalidUserDetailsException(
                    "Invalid First Name"
            );
        }

        System.out.println("Valid First Name");
    }
    public void validateLastName(String lastName)
            throws InvalidUserDetailsException {

        if (!Pattern.matches("[A-Z][a-z]{2,}", lastName)) {

            throw new InvalidUserDetailsException(
                    "Invalid Last Name"
            );
        }

        System.out.println("Valid Last Name");
    }
    public void validateEmail(String email)
            throws InvalidUserDetailsException {

        String regex =
                "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$";

        if (!Pattern.matches(regex, email)) {

            throw new InvalidUserDetailsException(
                    "Invalid Email"
            );
        }

        System.out.println("Valid Email");
    }
    public void validateMobile(String mobile)
            throws InvalidUserDetailsException {

        if (!Pattern.matches(
                "^[0-9]{2}\\s[0-9]{10}$",
                mobile
        )) {
            throw new InvalidUserDetailsException(
                    "Invalid Mobile Number"
            );
        }

        System.out.println("Valid Mobile Number");
    }
    public void validatePassword(String password)
            throws InvalidUserDetailsException {

        String regex =
                "^(?=.*[A-Z])" +
                        "(?=.*[0-9])" +
                        "(?=.*[@#$%^&+=!])" +
                        ".{8,}$";

        if (!Pattern.matches(regex, password)) {

            throw new InvalidUserDetailsException(
                    "Invalid Password"
            );
        }

        System.out.println("Valid Password");
    }
}
public class Day21Assignment1 {

    public static void main(String[] args) {

        UserRegistration user = new UserRegistration();

        try {
            user.validateFirstName("Yeda");
            user.validateLastName("Kumar");
            user.validateEmail("abc.xyz@bl.co.in");
            user.validateMobile("91 9919819801");
            user.validatePassword("Password1@");
            System.out.println("\nAll User Details are Valid ");
        }

        catch (InvalidUserDetailsException e) {

            System.out.println(
                    "\nException: " + e.getMessage()
            );
        }
    }
}