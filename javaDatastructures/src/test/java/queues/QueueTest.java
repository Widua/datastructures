package queues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    static Stream<Supplier<Queue<Integer>>> queueProvider() {
        return Stream.of(
                NodeBasedQueue::new,
                ArrayBasedQueue::new
        );
    }

    @ParameterizedTest
    @MethodSource("queueProvider")
    public void testEnqueue(Supplier<Queue<Integer>> queueSupplier) {
        Queue<Integer> queue = queueSupplier.get();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(10);
        queue.enqueue(15);

        assertEquals(5, queue.size());
        assertEquals(5, queue.peek());
    }

    @ParameterizedTest
    @MethodSource("queueProvider")
    public void testDeque(Supplier<Queue<Integer>> queueSupplier) {
        Queue<Integer> queue = queueSupplier.get();

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);

        Integer queueInt = queue.deque();

        assertEquals(5, queueInt);
        assertEquals(6, queue.peek());
        assertEquals(2, queue.size());
    }
}