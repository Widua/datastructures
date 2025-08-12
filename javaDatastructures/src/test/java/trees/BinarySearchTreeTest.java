package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void insertionTest(){
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        assertEquals(7,bst.size());
        assertEquals(10,bst.getRoot().value);
        assertEquals(2,bst.getRoot().leftChild.leftChild.value);
        assertEquals(14,bst.getRoot().rightChild.leftChild.value);
    }


}