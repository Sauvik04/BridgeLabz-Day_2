import java.util.*;
public class Day5Assignment6 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int divider = sc.nextInt();
        int divisor = sc.nextInt();
        int Q = divider / divisor;
        int R = divider % divisor;
        System.out.println(Q);
        System.out.println(R);
    }
}
