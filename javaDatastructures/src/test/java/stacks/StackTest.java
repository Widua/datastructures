package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void creatingStackTest(){
        Stack<Integer> stack = new Stack<>();

        assertEquals(0,stack.size());
    }

    @Test
    public void addingElementsToStackTest(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2,stack.size());
        assertEquals(2,stack.peek());
    }

    @Test
    public void poppingElementsFromStackTest(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        Integer popped = stack.pop();

        assertEquals(2,popped);
        assertEquals(1,stack.size());
    }


}