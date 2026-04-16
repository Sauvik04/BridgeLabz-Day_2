import java.util.*;
public class Day1Assignment6 {
    static int count = 0;
    static{
        System.out.println("It will run first");
        count = 100;
    }
    static void display(){
        System.out.println("Static method executed");
        System.out.println("current value " + count);
    }
    public static void main(String[]args){
        System.out.println("main method executed");
        display();
        count += 50;
        System.out.println("updated count " + count);
    }
}
