package queues;

public class ArrayBasedQueue<T> implements Queue<T> {

    private int tail;
    private int head;
    private int capacity;
    private int length;
    private Object[] storage;


    public ArrayBasedQueue(){
        this.tail = this.head = this.length = 0;
        this.capacity = 3;
        this.storage = new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T deque() {
        T value = (T) storage[head];
        storage[head]=null;
        head++;
        length--;
        return value;
    }

    @Override
    public void enqueue(T value) {
        if ((head %storage.length==tail% storage.length) && length!=0){
            Object[] currentArr = storage;
            capacity = capacity*capacity;
            storage = new Object[capacity];
            System.arraycopy(currentArr,head,storage,0,currentArr.length);
            System.arraycopy(currentArr,0,storage,length,tail%currentArr.length);
            head = 0;
            tail = currentArr.length;
        }
        storage[tail%storage.length] = value;
        tail++;
        length++;
    }

    @Override
    public T peek() {
        T value = (T) storage[head];
        return value;
    }
}
