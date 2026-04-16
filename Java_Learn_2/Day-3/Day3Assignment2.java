import java.util.*;
public class Day3Assignment2 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]arr = new int[n];
        for(int i =0; i < arr.length;i++){
            arr[i] = input.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry <Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "->" + value);
        }
    }
}
