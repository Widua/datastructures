package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void insertionTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        assertEquals(7, bst.size());
        assertEquals(10, bst.getRoot().value);
        assertEquals(2, bst.getRoot().leftChild.leftChild.value);
        assertEquals(14, bst.getRoot().rightChild.leftChild.value);
    }

    @Test
    public void findTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        assertTrue(bst.find(15));
        assertTrue(bst.find(2));
        assertTrue(bst.find(10));
        assertFalse(bst.find(100));
        assertFalse(bst.find(1));
    }

    @Test
    public void bfsFindTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        assertTrue(bst.bfsFind(15));
        assertTrue(bst.bfsFind(2));
        assertTrue(bst.bfsFind(10));
        assertFalse(bst.bfsFind(100));
        assertFalse(bst.bfsFind(1));
    }

    @Test
    public void noChildDeletionTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        bst.delete(2);
        assertFalse(bst.find(2));
        assertEquals(6, bst.size());
    }

    @Test
    public void oneChildDeletionTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        bst.delete(14);
        assertFalse(bst.find(14));
        assertEquals(6, bst.size());
        assertTrue(bst.find(13));
        assertEquals(13, bst.getRoot().rightChild.leftChild.value);
    }

    @Test
    public void twoChildNodeNoDeepDeletionTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        bst.delete(5);

        assertTrue(bst.find(8));
        assertTrue(bst.find(2));
        assertEquals(2, bst.getRoot().leftChild.value);
    }

    @Test
    public void twoChildNodeDeepDeletionTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);
        bst.insert(3);
        bst.insert(4);

        bst.delete(5);

        assertEquals(4, bst.getRoot().leftChild.value);
    }

    @Test
    public void compareSameTreesTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        BinarySearchTree bst2 = new BinarySearchTree();

        bst2.insert(10);
        bst2.insert(5);
        bst2.insert(2);
        bst2.insert(8);
        bst2.insert(15);
        bst2.insert(14);
        bst2.insert(13);


        assertTrue(bst.compare(bst.getRoot(), bst2.getRoot()));
    }

    @Test
    public void compareNotSameTreesTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        BinarySearchTree bst2 = new BinarySearchTree();

        bst2.insert(10);
        bst2.insert(5);
        bst2.insert(2);
        bst2.insert(8);
        bst2.insert(15);
        bst2.insert(13);
        bst2.insert(14);


        assertFalse(bst.compare(bst.getRoot(), bst2.getRoot()));
    }

    @Test
    public void testPreOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        String asString = bst.asString(TraversalMode.PREORDER);

        assertEquals("[10, 5, 2, 8, 15, 14, 13]", asString);
    }

    @Test
    public void testInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        String asString = bst.asString(TraversalMode.INORDER);

        assertEquals("[2, 5, 8, 10, 13, 14, 15]", asString);
    }

    @Test
    public void testPostOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        String asString = bst.asString(TraversalMode.POSTORDER);

        assertEquals("[2, 8, 5, 13, 14, 15, 10]", asString);
    }
}