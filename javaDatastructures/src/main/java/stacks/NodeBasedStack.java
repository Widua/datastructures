package stacks;

public class NodeBasedStack<T> implements Stack<T> {
    private int length;
    private Node<T> head;

    public NodeBasedStack(){
        this.head = null;
        length = 0;
    }

    public void push(T value){
        Node<T> node = new Node<>(value);
        length++;
        if (head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public T pop(){
        length--;
        Node<T> node = head;
        head = node.next;
        return node.value;
    }

    public T peek(){
        return head.value;
    }

    public int size(){
        return length;
    }

}

class Node<T>{
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }
}
