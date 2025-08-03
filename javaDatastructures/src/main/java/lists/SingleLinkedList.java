package lists;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements List<T>{
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public int size() {
        return length;
    }

    public SingleLinkedList(){
        this.length = 0;
        head = tail = null;
    }

    public T get(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                throw new NoSuchElementException();
            }
            node = node.next;
        }
        return node.value;
    }

    public void add(T value) {
        length++;
        Node<T> currentNode = new Node<>(value);
        if (head == null) {
            head = tail = currentNode;
            return;
        }
        Node<T> currentTail = tail;
        currentTail.next = currentNode;
        tail = currentNode;
    }

    public void delete(int index) {
        length--;
        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            if (node.next == null) {
                throw new NoSuchElementException();
            }
            node = node.next;
        }

        node.next = node.next.next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Node<T> node = head;

        while (node.next != null) {
            builder.append(node.value).append(", ");
            node = node.next;
        }

        builder.append(node.value).append("]");

        return builder.toString();
    }
}

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
