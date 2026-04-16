import java.util.*;
public class Day3Assignment5 {
    public static void main(String[]main){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]arr = new int[n];
        for(int i =0; i < arr.length;i++){
            arr[i] = input.nextInt();
        }
        for(int i = 0; i < arr.length;i +=2){
            System.out.println(arr[i]);
        }
    }
}
