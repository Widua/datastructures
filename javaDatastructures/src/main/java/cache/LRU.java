package cache;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
    private int length;
    private int capacity;
    private Node<V> head;
    private Node<V> tail;
    private Map<K, Node<V>> lookup;
    private Map<Node<V>, K> reverseLookup;

    public LRU(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        this.head = this.tail = null;
        this.lookup = new HashMap<>();
        this.reverseLookup = new HashMap<>();
    }

    public void update(K key, V value) {
        Node<V> node = lookup.get(key);
        if (node == null) {
            node = new Node<>(value);
            length++;
            prepend(node);
            trimCache();

            this.lookup.put(key,node);
            this.reverseLookup.put(node,key);
        } else {
            detach(node);
            prepend(node);
            node.value = value;
        }


    }

    public V get(K key) {
        Node<V> node = lookup.get(key);
        if (node == null) {
            return null;
        }

        detach(node);
        prepend(node);

        return node.value;
    }

    private void detach(Node<V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (this.head == node) {
            this.head = this.head.next;
        }
        if (this.tail == node) {
            this.tail = this.tail.prev;
        }

        node.prev = null;
        node.next = null;
    }

    private void prepend(Node<V> node) {
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }

        node.next = this.head;
        this.head.prev = node;

        this.head = node;
    }

    private void trimCache() {
        if (this.length <= this.capacity){
            return;
        }
        Node<V> tail = this.tail;
        detach(this.tail);
        K key = reverseLookup.get(tail);
        this.lookup.remove(key);
        this.reverseLookup.remove(tail);
        this.length--;

    }

}

class Node<T> {
    T value;
    Node<T> prev;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }

}
