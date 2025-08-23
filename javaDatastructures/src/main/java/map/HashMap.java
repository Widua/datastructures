package map;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {

    private List<List<MapEntry<K, V>>> storage;
    private int length;
    private int load;

    public HashMap() {
        this.length = 0;
        this.load = 5;
        this.storage = new ArrayList<>();
        for (int i = 0; i < load; i++) {
            storage.add(new ArrayList<>());
        }
    }

    @Override
    public void put(K key, V value) {
        length++;
        int hash = key.hashCode();
        int position = hash % load;

        if (length >= load) {
            List<MapEntry<K, V>> entries = storage.stream().flatMap(List::stream).toList();
            this.length = 0;
            this.load = load * load;
            this.storage = new ArrayList<>();
            for (int i = 0; i < load; i++) {
                storage.add(new ArrayList<>());
            }
            entries.forEach((entry) -> put(entry.key, entry.value));
            length = entries.size() + 1;
        }

        if (storage.size() <= position) {
            storage.add(position, new ArrayList<>());
        }

        if (storage.get(position).stream().anyMatch(entry -> entry.key.equals(key))) {
            remove(key);
        }
        storage.get(position).add(new MapEntry<>(key, value));
    }

    @Override
    public void remove(K key) {
        length--;
        int hash = key.hashCode();
        int position = hash % load;
        List<MapEntry<K, V>> posList = storage.get(position);
        posList.removeIf((entry) -> entry.key.equals(key));
    }

    @Override
    public void replace(K key, V value) {
        put(key, value);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int position = hash % load;
        for (MapEntry<K, V> kvMapEntry : storage.get(position)) {
            if (kvMapEntry.key.equals(key)){
                return kvMapEntry.value;
            }
        }
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