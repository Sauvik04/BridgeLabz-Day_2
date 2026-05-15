import java.util.regex.Pattern;

// Functional Interface
@FunctionalInterface
interface UserValidation {

    boolean validate(String input);
}

// Custom Exception
class InvalidUserDetailException extends Exception {

    public InvalidUserDetailException(String message) {

        super(message);
    }
}

// User Registration Class
class UserRegister {

    // First Name Validation
    UserValidation firstNameValidation =
            name -> Pattern.matches(
                    "[A-Z][a-z]{2,}",
                    name);

    // Last Name Validation
    UserValidation lastNameValidation =
            name -> Pattern.matches(
                    "[A-Z][a-z]{2,}",
                    name);

    // Email Validation
    UserValidation emailValidation =
            email -> Pattern.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
                    email);

    // Mobile Number Validation
    UserValidation mobileValidation =
            mobile -> Pattern.matches(
                    "^[0-9]{2}\\s[0-9]{10}$",
                    mobile);

    // Password Validation
    UserValidation passwordValidation =
            password -> Pattern.matches(
                    "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
                    password);

    // Validate First Name
    public boolean validateFirstName(String name)
            throws InvalidUserDetailException {

        if(firstNameValidation.validate(name)) {

            return true;
        }

        throw new InvalidUserDetailException(
                "Invalid First Name");
    }

    // Validate Last Name
    public boolean validateLastName(String name)
            throws InvalidUserDetailException {

        if(lastNameValidation.validate(name)) {

            return true;
        }

        throw new InvalidUserDetailException(
                "Invalid Last Name");
    }

    // Validate Email
    public boolean validateEmail(String email)
            throws InvalidUserDetailException {

        if(emailValidation.validate(email)) {

            return true;
        }

        throw new InvalidUserDetailException(
                "Invalid Email");
    }

    // Validate Mobile Number
    public boolean validateMobile(String mobile)
            throws InvalidUserDetailException {

        if(mobileValidation.validate(mobile)) {

            return true;
        }

        throw new InvalidUserDetailException(
                "Invalid Mobile Number");
    }

    // Validate Password
    public boolean validatePassword(String password)
            throws InvalidUserDetailException {

        if(passwordValidation.validate(password)) {

            return true;
        }

        throw new InvalidUserDetailException(
                "Invalid Password");
    }
}

// Main Class
public class Day23Assignment {

    public static void main(String[] args) {

        UserRegister user =
                new UserRegister();

        try {

            System.out.println(
                    "First Name Valid: " +
                            user.validateFirstName("Lambda"));

            System.out.println(
                    "Last Name Valid: " +
                            user.validateLastName("Kumar"));

            System.out.println(
                    "Email Valid: " +
                            user.validateEmail(
                                    "abc@gmail.com"));

            System.out.println(
                    "Mobile Valid: " +
                            user.validateMobile(
                                    "91 9876543210"));

            System.out.println(
                    "Password Valid: " +
                            user.validatePassword(
                                    "Password@1"));
        }

        catch(InvalidUserDetailException e) {

            System.out.println(
                    "Exception: " +
                            e.getMessage());
        }
    }
}