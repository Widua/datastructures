package lists;

public interface List<T> {
    int size();
    T get(int index);
    void add(T value);
    void delete(int index);

}
