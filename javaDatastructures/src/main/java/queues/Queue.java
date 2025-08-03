package queues;

public interface Queue<T> {
    int size();
    T deque();
    void enqueue(T value);
    T peek();
}
