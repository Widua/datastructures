package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeBasedStackTest {

    @Test
    public void creatingStackTest(){
        NodeBasedStack<Integer> stack = new NodeBasedStack<>();

        assertEquals(0,stack.size());
    }

    @Test
    public void addingElementsToStackTest(){
        NodeBasedStack<Integer> stack = new NodeBasedStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2,stack.size());
        assertEquals(2,stack.peek());
    }

    @Test
    public void poppingElementsFromStackTest(){
        NodeBasedStack<Integer> stack = new NodeBasedStack<>();

        stack.push(1);
        stack.push(2);
        Integer popped = stack.pop();

        assertEquals(2,popped);
        assertEquals(1,stack.size());
    }


}