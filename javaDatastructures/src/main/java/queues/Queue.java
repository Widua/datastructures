package queues;

public class Queue<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public Queue(){
        this.head = this.tail = null;
        this.length = 0;
    }

    public void enqueue(T value){
        this.length ++;
        Node<T> newNode = new Node<>(value);
        if (tail == null){
            head = tail = newNode;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public int size(){
        return length;
    }

    public T deque(){
        if (head == null){
            return null;
        }
        this.length --;
        Node<T> head = this.head;
        this.head = this.head.next;
        return head.value;
    }
    public T peek(){
        return head.value;
    }
}

class Node<T>{
    T value;
    Node<T> next;

    Node(T value){
        this.value = value;
    }
}
