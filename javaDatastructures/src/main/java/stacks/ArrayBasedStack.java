package stacks;


import java.util.NoSuchElementException;

public class ArrayBasedStack<T> implements Stack<T> {

    private int tail;
    private int capacity;
    private Object[] storage;

    public ArrayBasedStack() {
        this.tail = 0;
        this.capacity = 3;
        this.storage = new Object[capacity];
    }


    @Override
    public int size() {
        return tail;
    }

    @Override
    public void push(T value) {
        if (tail == capacity) {
            Object[] currentStorage = storage;
            capacity = capacity * capacity;
            storage = new Object[capacity];
            System.arraycopy(currentStorage, 0, storage, 0, tail);
        }
        storage[tail] = value;
        tail++;

    }

    @Override
    public T pop() {
        if (tail == 0) {
            throw new NoSuchElementException();
        }
        T value = (T) storage[tail-1];
        tail--;
        return value;
    }

    @Override
    public T peek() {
        return (T) storage[tail-1];
    }
}
