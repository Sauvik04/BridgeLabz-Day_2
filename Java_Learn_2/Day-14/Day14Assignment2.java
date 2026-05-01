public class Day14Assignment2 {
    static class GenericNode<T> {
        T data;
        GenericNode<T> next;

        GenericNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
    static class GenericLinkedList<T> {
        private GenericNode<T> head;
        public void insertFirst(T data) {
            GenericNode<T> newNode = new GenericNode<>(data);
            newNode.next = head;
            head = newNode;
        }
        public void append(T data) {
            GenericNode<T> newNode = new GenericNode<>(data);

            if (head == null) {
                head = newNode;
                return;
            }

            GenericNode<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        public T deleteFirst() {
            if (head == null) return null;
            T value = head.data;
            head = head.next;
            return value;
        }
        public T peek() {
            return (head == null) ? null : head.data;
        }
        public boolean isEmpty() {
            return head == null;
        }
        public void display() {
            GenericNode<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }
    static class Stack<T> {
        private GenericLinkedList<T> list = new GenericLinkedList<>();

        public void push(T data) {
            list.insertFirst(data);
        }

        public T pop() {
            return list.deleteFirst();
        }

        public T peek() {
            return list.peek();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }
    static class Queue<T> {
        private GenericLinkedList<T> list = new GenericLinkedList<>();

        public void enqueue(T data) {
            list.append(data);
        }

        public T dequeue() {
            return list.deleteFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }
    public static void main(String[] args) {
        System.out.println("STACK:");
        Stack<Integer> stack = new Stack<>();
        stack.push(70);
        stack.push(30);
        stack.push(56);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
        System.out.println("\nQUEUE:");
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);
        queue.display();
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}