package queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayBasedQueueTest {

    @Test
    public void ringBufferCircularTest(){
        Queue<Integer> queue = new ArrayBasedQueue<>();

        queue.enqueue(5);
        queue.deque();
        queue.enqueue(10);
        queue.enqueue(8);
        queue.deque();
        queue.enqueue(9);

        assertEquals(2,queue.size());
        assertEquals(8,queue.peek());
    }

}
