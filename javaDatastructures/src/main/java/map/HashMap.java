package map;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {

    private List<List<MapEntry<K, V>>> storage;
    private int length;

    public HashMap() {
        this.length = 0;
        this.storage = new ArrayList<>();
    }


    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();



    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void replace(K key, V value) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V get(K key) {
        return null;
    }
}

class MapEntry<K, V> {
    K key;
    V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}