package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> storage;
    private int length;

    public MinHeap() {
        this.storage = new ArrayList<>();
        this.length = 0;
    }

    private void upHeap(int index){
        if (index == 0){
            return;
        }
        int parent = parent(index);
        Integer parentVal = storage.get(parent);
        Integer currVal = storage.get(index);

        if (parentVal > currVal){
            storage.set(index,parentVal);
            storage.set(parent,currVal);
            upHeap(parent);
        }
    }

    private void downHeap(int index){
        if (index >= length){
            return;
        }
        int leftChildIdx = leftChild(index);
        int rightChildIdx = rightChild(index);


        if (index >= this.length || leftChildIdx >= this.length){
            return;
        }
        int lval = storage.get(leftChildIdx);
        int rval = storage.get(rightChildIdx);
        int currVal = storage.get(index);

        if (lval > rval && currVal > rval ){
            storage.set(index,rval);
            storage.set(rightChildIdx,currVal);
            downHeap(rightChildIdx);
        } else if (rval > lval && currVal > lval){
            storage.set(index,lval);
            storage.set(leftChildIdx,currVal);
            downHeap(leftChildIdx);
        }
    }

    public int size() {
        return length;
    }

    public Integer delete() {
        if (length == 0){
            return -1;
        }
        length--;
        if (length == 1){
            Integer out = storage.getFirst();
            storage.removeFirst();
            return out;
        }

        Integer out = storage.getFirst();
        storage.set(0,storage.get(length));
        downHeap(0);
        return out;
    }

    public void insert(Integer value) {
        storage.addLast(value);
        upHeap(length);
        this.length++;
    }

    public Integer peek() {
        Integer root = storage.getFirst();
        return root;
    }

    private int parent(int index){
        return (index-1) /2;
    }
    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index){
        return index * 2 + 2;
    }

}
