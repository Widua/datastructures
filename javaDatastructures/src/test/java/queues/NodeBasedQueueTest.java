package queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeBasedQueueTest {

    @Test
    public void testEnqueue(){
        NodeBasedQueue<Integer> queue = new NodeBasedQueue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);

        assertEquals(3,queue.size());
        assertEquals(5,queue.peek());
    }

    @Test
    public void testDeque(){
        NodeBasedQueue<Integer> queue = new NodeBasedQueue<>();

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);

        Integer queueInt = queue.deque();

        assertEquals(5,queueInt);
        assertEquals(6,queue.peek());
        assertEquals(2,queue.size());
    }

}