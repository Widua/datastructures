package lists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class SingleLinkedListTest{

    @Test
    public void addingElementsToLinkedList(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        assertEquals(1,linkedList.get(0));
    }

    @Test
    public void sizeTest(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        assertEquals(4,linkedList.size());
    }

    @Test
    public void toStringTest(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(10);

        assertEquals("[ 8, 2, 5, 10 ]",linkedList.toString());
    }

}