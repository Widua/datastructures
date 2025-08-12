package trees;

public class BinarySearchTree implements Tree {

    private int height;
    private int length;
    private BTNode root;

    public BinarySearchTree() {
        this.height = 0;
        this.length = 0;
        this.root = null;
    }

    public BTNode getRoot() {
        return root;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void insert(Integer value) {
        if (root == null){
            root = new BTNode(value);
            length++;
            return;
        }
        recInsert(value,root);
        length++;
    }

    private void recInsert(Integer value, BTNode curr) {

        if (curr.leftChild == null && curr.value >= value) {
            curr.leftChild = new BTNode(value);
            return;
        }
        if (curr.rightChild == null && curr.value < value){
            curr.rightChild = new BTNode(value);
            return;
        }
        if (curr.value >= value){
            recInsert(value,curr.leftChild);
        }
        if (curr.value < value){
            recInsert(value,curr.rightChild);
        }
    }

    @Override
    public void delete(Integer value) {

    }

    private boolean recFind(Integer value, BTNode curr){
        if (curr.value.equals(value)){
            return true;
        }

        if (curr.value >= value && curr.leftChild != null){
            return recFind(value,curr.leftChild);
        }
        if (curr.value < value && curr.rightChild != null){
            return recFind(value,curr.rightChild);
        }

        return false;
    }

    @Override
    public boolean find(Integer value) {
        return recFind(value,root);
    }


}

class BTNode {
    Integer value;
    BTNode leftChild;
    BTNode rightChild;

    public BTNode(Integer value) {
        this.value = value;
    }

}
