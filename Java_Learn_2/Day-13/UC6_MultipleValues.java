import java.util.*;
class UC6_MultipleValues {
    public static <T extends Comparable<T>> T testMaximum(T... values) {
        List<T> list = Arrays.asList(values);
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
    public static void main(String[] args) {
        System.out.println("Max: " + testMaximum(10, 20, 5, 40, 15));
        System.out.println("Max: " + testMaximum("Cat", "Dog", "Elephant", "Bee","Aandu"));
    }
}