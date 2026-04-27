import java.util.Random;
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front, rear;
    public void enqueue(String data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
class Player {
    private String name;
    private Queue cards;

    public Player(String name) {
        this.name = name;
        this.cards = new Queue();
    }

    public void addCard(String card) {
        cards.enqueue(card);
    }

    public void showCards() {
        System.out.println(name + "'s cards:");
        cards.display();
        System.out.println();
    }
}
public class Day11Assignment5 {

    static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public static void main(String[] args) {

        String[] deck = new String[52];
        int k = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[k++] = ranks[j] + " of " + suits[i];
            }
        }
        shuffle(deck);
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        int index = 0;
        for (int i = 0; i < 4; i++) {
            String[] temp = new String[9];

            for (int j = 0; j < 9; j++) {
                temp[j] = deck[index++];
            }
            sort(temp);
            for (int j = 0; j < 9; j++) {
                players[i].addCard(temp[j]);
            }
        }
        for (int i = 0; i < 4; i++) {
            players[i].showCards();
        }
    }
    public static void shuffle(String[] deck) {
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int j = rand.nextInt(deck.length);

            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
    public static void sort(String[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = 0; j < cards.length - i - 1; j++) {

                if (getRank(cards[j]) > getRank(cards[j + 1])) {
                    String temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }
    public static int getRank(String card) {
        String[] rankOrder = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        for (int i = 0; i < rankOrder.length; i++) {
            if (card.startsWith(rankOrder[i])) {
                return i;
            }
        }
        return -1;
    }
}