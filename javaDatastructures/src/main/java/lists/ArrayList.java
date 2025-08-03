package lists;


import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private int length;
    private int capacity;
    private Object[] array;

    public ArrayList() {
        this.length = 0;
        this.capacity = 3;
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T get(int index) {
        if (index == capacity) {
            throw new NoSuchElementException();
        }
        return (T) array[index];
    }

    @Override
    public void add(T value) {
        if (length == capacity) {
            Object[] currArr = array;
            capacity = capacity * capacity;
            array = new Object[capacity];
            System.arraycopy(currArr, 0, array, 0, currArr.length);
        }

        array[length] = value;
        length++;
    }

    @Override
    public void delete(int index) {
        if (index == capacity) {
            throw new NoSuchElementException();
        }
        array[index] = null;
        length--;
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (Object o : Arrays.copyOfRange(array, 0, length)) {
            T value = (T)o;
            builder.append(value).append(", ");
        }
        builder.delete(builder.length()-2,builder.length());
        builder.append("]");

        return builder.toString();
    }
}
