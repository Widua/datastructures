package lists;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> {
    private Node<T> head;

    public int size() {
        int size = 1;
        Node<T> node = head;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
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
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(value);
    }

    public void delete(int index) {
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
        builder.append("[ ");

        Node<T> node = head;

        while (node.next != null) {
            builder.append(node.value).append(", ");
            node = node.next;
        }

        builder.append(node.value).append(" ]");

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
