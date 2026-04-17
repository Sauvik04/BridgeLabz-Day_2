import java.util.*;
public class Day5Assignment1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of flips: ");
        int n = sc.nextInt();
        if(n <= 2){
            System.out.println("Enter positive number");
            return;
        }
        Random rand = new Random();
        int heads = 0;
        int tails = 0;
        for(int i = 0; i < n;i++){
            double result = rand.nextDouble();
            if(result < 0.5){
                tails++;
            }else{
                heads++;
            }
        }
        double result1 = (heads * 100.0)/n;
        double result2 = (tails * 100.0)/n;
        System.out.println(result1);
        System.out.println(result2);
    }
}
