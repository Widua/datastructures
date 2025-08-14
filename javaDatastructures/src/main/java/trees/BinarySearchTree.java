package trees;

import java.util.*;

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
        if (root == null) {
            root = new BTNode(value);
            length++;
            return;
        }
        recInsert(value, root);
        length++;
    }

    private void recInsert(Integer value, BTNode curr) {

        if (curr.leftChild == null && curr.value >= value) {
            curr.leftChild = new BTNode(value);
            return;
        }
        if (curr.rightChild == null && curr.value < value) {
            curr.rightChild = new BTNode(value);
            return;
        }
        if (curr.value >= value) {
            recInsert(value, curr.leftChild);
        }
        if (curr.value < value) {
            recInsert(value, curr.rightChild);
        }
    }

    @Override
    public void delete(Integer value) {
        length--;

        BTNode parent = recGetParent(value, root);
        if (parent == null) {

            throw new NoSuchElementException();
        }
        BTNode toDelete;

        if (parent.value >= value) {
            toDelete = parent.leftChild;
            if (toDelete.leftChild == null && toDelete.rightChild == null) {
                parent.leftChild = null;
                return;
            }
            if (toDelete.leftChild == null) {
                parent.leftChild = toDelete.rightChild;
                return;
            }
            if (toDelete.rightChild == null) {
                parent.leftChild = toDelete.leftChild;
                return;
            }

            BTNode max = deleteWhenTwoChild(toDelete);
            parent.leftChild = max;
        }
        if (parent.value < value) {
            toDelete = parent.rightChild;
            if (toDelete.leftChild == null && toDelete.rightChild == null) {
                parent.rightChild = null;
                return;
            }
            if (toDelete.leftChild == null) {
                parent.rightChild = toDelete.rightChild;
                return;
            }
            if (toDelete.rightChild == null) {
                parent.rightChild = toDelete.leftChild;
                return;
            }

            BTNode max = deleteWhenTwoChild(toDelete);
            parent.rightChild = max;
        }

    }

    private BTNode deleteWhenTwoChild(BTNode toDelete) {
        BTNode maxParent = toDelete.leftChild;
        BTNode max = maxParent;

        while (maxParent.rightChild != null && maxParent.rightChild.rightChild != null) {
            maxParent = maxParent.rightChild;
        }

        if (maxParent.rightChild != null) {
            max = maxParent.rightChild;
        }

        maxParent.rightChild = null;
        max.leftChild = toDelete.leftChild;
        max.rightChild = toDelete.rightChild;

        return max;
    }

    private BTNode recGetParent(Integer value, BTNode curr) {
        if (curr.leftChild.value.equals(value) || curr.rightChild.value.equals(value)) {
            return curr;
        }

        if (curr.value >= value && curr.leftChild != null) {
            return recGetParent(value, curr.leftChild);
        }
        if (curr.value < value && curr.rightChild != null) {
            return recGetParent(value, curr.rightChild);
        }

        return null;
    }

    private boolean recFind(Integer value, BTNode curr) {
        if (curr.value.equals(value)) {
            return true;
        }

        if (curr.value >= value && curr.leftChild != null) {
            return recFind(value, curr.leftChild);
        }
        if (curr.value < value && curr.rightChild != null) {
            return recFind(value, curr.rightChild);
        }

        return false;
    }

    @Override
    public boolean find(Integer value) {
        return recFind(value, root);
    }

    @Override
    public boolean bfsFind(Integer value) {
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BTNode curr = queue.poll();
            if (Objects.equals(curr.value, value)) {
                return true;
            }

            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
        }

        return false;
    }

    public void preOrderTraverse(BTNode curr,StringBuilder builder){
        if (curr == null){
            return;
        }
        builder.append(curr.value).append(", ");
        preOrderTraverse(curr.leftChild,builder);
        preOrderTraverse(curr.rightChild,builder);
    }

    public void inOrderTraverse(BTNode curr,StringBuilder builder){
        if (curr == null){
            return;
        }
        inOrderTraverse(curr.leftChild,builder);
        builder.append(curr.value).append(", ");
        inOrderTraverse(curr.rightChild,builder);
    }

    public void postOrderTraverse(BTNode curr, StringBuilder builder){
        if (curr == null){
            return;
        }
        postOrderTraverse(curr.leftChild,builder);
        postOrderTraverse(curr.rightChild,builder);
        builder.append(curr.value).append(", ");
    }

    @Override
    public String asString(TraversalMode mode) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        switch (mode){
            case PREORDER -> {
                preOrderTraverse(root,builder);
            }
            case INORDER -> {
                inOrderTraverse(root,builder);
            }
            case POSTORDER -> {
                postOrderTraverse(root,builder);
            }
            default -> {
                throw new UnsupportedOperationException();
            }
        }

        builder.setCharAt(builder.length()-2,']');
        return builder.toString().trim();
    }


    @Override
    public boolean compare(BTNode a, BTNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (!a.value.equals(b.value)) {
            return false;
        }
        return compare(a.leftChild, b.leftChild) && compare(a.rightChild, b.rightChild);
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
