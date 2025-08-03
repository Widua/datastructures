package queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void testEnqueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);

        assertEquals(3,queue.size());
        assertEquals(5,queue.peek());
    }

    @Test
    public void testDeque(){
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);

        Integer queueInt = queue.deque();

        assertEquals(5,queueInt);
        assertEquals(6,queue.peek());
        assertEquals(2,queue.size());
    }

}