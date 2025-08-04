package lists;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements List<T> {

    private int length;
    private DNode<T> head;
    private DNode<T> tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
        this.length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T get(int index) {
        DNode<T> node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                throw new NoSuchElementException();
            }
            node = node.next;
        }
        return node.value;
    }

    @Override
    public void add(T value) {
        DNode<T> addedValue = new DNode<>(value);
        length++;
        if (head == null && tail == null) {
            head = addedValue;
            tail = addedValue;
            head.next = tail;
            tail.prev = head;
        }
        addedValue.prev = tail;
        this.tail.next = addedValue;
        this.tail = addedValue;
    }

    @Override
    public void delete(int index) {
        length--;
        DNode<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            if (node.next == null) {
                throw new NoSuchElementException();
            }

            node = node.next;
        }
        node = node.next;

        DNode<T> prevToDeleted = node.prev;
        DNode<T> nextToDeleted = node.next;

        prevToDeleted.next = nextToDeleted;
        nextToDeleted.prev = prevToDeleted;


    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        DNode<T> node = head;

        while (node.next != null) {
            builder.append(node.value).append(", ");
            node = node.next;
        }

        builder.append(node.value).append("]");

        return builder.toString();
    }
}

class DNode<T> {
    T value;
    DNode<T> prev;
    DNode<T> next;

    DNode(T value) {
        this.value = value;
    }

}