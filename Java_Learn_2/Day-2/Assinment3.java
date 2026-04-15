import java.util.*;
public class Assinment3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int i = 1, sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println(sum);

    }
}
