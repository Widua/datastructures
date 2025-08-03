package stacks;

public interface Stack<T> {
    int size();
    void push(T value);
    T pop();
    T peek();

}
