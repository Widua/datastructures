package queues;

public class ArrayBasedQueue<T> implements Queue<T> {

    private int tail;
    private int head;
    private int capacity;
    private Object[] storage;


    public ArrayBasedQueue(){
        this.tail = this.head = 0;
        this.capacity = 3;
        this.storage = new Object[capacity];
    }

    @Override
    public int size() {
        return tail-head;
    }

    @Override
    public T deque() {
        T value = (T) storage[head];

        storage[head]=null;
        head++;
        return value;
    }

    @Override
    public void enqueue(T value) {
        if (tail == capacity){
            capacity = capacity*capacity;
            Object[] currStorage = storage;
            storage = new Object[capacity];
            System.arraycopy(currStorage,head,storage,0,currStorage.length);
        }
        storage[tail] = value;
        tail++;
    }

    @Override
    public T peek() {
        T value = (T) storage[head];
        return value;
    }
}
