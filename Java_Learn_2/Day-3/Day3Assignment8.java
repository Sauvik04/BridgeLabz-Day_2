import java.util.*;
public class Day3Assignment8 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]arr = new int[n];
        for(int i =0; i < arr.length;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++){
            for(int j = i +1;j < arr.length;j++){
                if(arr[i] == arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }
    }
}
