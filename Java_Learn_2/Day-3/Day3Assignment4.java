import java.util.*;
public class Day3Assignment4 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]arr = new int[n];
        for(int i =0; i < arr.length;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
