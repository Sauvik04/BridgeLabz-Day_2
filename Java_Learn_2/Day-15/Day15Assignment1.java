import java.util.ArrayList;

class MyMapNode<K, V> {
    K key;
    V value;

    MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
class MyHashMap<K, V> {

    private final int numBuckets = 10;
    private ArrayList<ArrayList<MyMapNode<K, V>>> bucketArray;

    public MyHashMap() {
        bucketArray = new ArrayList<>();

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(new ArrayList<>());
        }
    }
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numBuckets;
    }
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        ArrayList<MyMapNode<K, V>> bucket = bucketArray.get(index);

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // update
                return;
            }
        }

        bucket.add(new MyMapNode<>(key, value));
    }
    public V get(K key) {
        int index = getBucketIndex(key);
        ArrayList<MyMapNode<K, V>> bucket = bucketArray.get(index);

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = getBucketIndex(key);
        ArrayList<MyMapNode<K, V>> bucket = bucketArray.get(index);

        bucket.removeIf(node -> node.key.equals(key));
    }
    public void display() {
        for (ArrayList<MyMapNode<K, V>> bucket : bucketArray) {
            for (MyMapNode<K, V> node : bucket) {
                System.out.println(node.key + " -> " + node.value);
            }
        }
    }
}

public class Day15Assignment1 {
    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<>();
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }

        System.out.println("Word Frequency (UC1):");
        map.display();
        String paragraph = "Paranoids are not paranoid because they are paranoid " +
                "but because they keep putting themselves deliberately into paranoid avoidable situations";

        String[] words2 = paragraph.toLowerCase().split(" ");

        MyHashMap<String, Integer> map2 = new MyHashMap<>();

        for (String word : words2) {
            Integer count = map2.get(word);

            if (count == null) {
                map2.put(word, 1);
            } else {
                map2.put(word, count + 1);
            }
        }
        System.out.println("\nWord Frequency (UC2):");
        map2.display();
        map2.remove("avoidable");

        System.out.println("\nAfter Removing 'avoidable' (UC3):");
        map2.display();
    }
}