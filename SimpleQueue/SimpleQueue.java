package Chapter4.SimpleQueue;

public class SimpleQueue<T> {

    private static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }
    Node<T> front;
    Node<T> rear;
    int size;

    public SimpleQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue IsEmpty theres No anyone..");
        }
        T data = front.data;
        front = front.next;// ابدأ من العنصر الثاني مش الاول عشان نقدر نحذف 
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue IsEmpty theres No anyone..");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        SimpleQueue<String> names = new SimpleQueue<>();
        names.enqueue("Huda");
        names.enqueue("Mohammed");
        names.enqueue("Iyad");
        String names1 = names.dequeue();
        System.out.println("The Front Of Queue: " + names1);
        String NewFront=names.peek();
        System.out.println("The NewFront Of Queue: " + NewFront);
        System.out.println("The Queue IsEmpty: " + names.isEmpty());
        names.dequeue();
        names.dequeue();
        System.out.println("The Queue IsEmpty: " + names.isEmpty());

    }
}
