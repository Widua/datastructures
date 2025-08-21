package map;

public interface Map<K,V> {
    void put(K key, V value);
    void remove(K key);
    void replace(K key, V value);
    int size();
    V get(K key);
}
