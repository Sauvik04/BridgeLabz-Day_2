import java.util.*;
public class Assignment7 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int orig = n;
        int rev = 0;

        for (; n > 0; n = n / 10) {
            int digit = n % 10;
            rev = rev * 10 + digit;
        }

        if (orig == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
