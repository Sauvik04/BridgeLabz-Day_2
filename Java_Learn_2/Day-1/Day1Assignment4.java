import java.util.*;

public class Day1Assignment4 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        //String s = input.nextLine();
        int sum = 0;
        int other = 0;
        for(String arg : args){
            if(isInteger(arg)){
                sum += Integer.parseInt(arg);
            }else{
                other++;
            }
        }
        System.out.println("Sum" + sum);
        System.out.println("Other" + other);
    }
    static boolean isInteger(String s){
        for(int i = 0;i < s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
