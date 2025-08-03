package stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    static Stream<Supplier<Stack<Integer>>> stackProvider() {
        return Stream.of(
                NodeBasedStack::new,
                ArrayBasedStack::new
        );
    }

    @ParameterizedTest
    @MethodSource("stackProvider")
    public void creatingStackTest(Supplier<Stack<Integer>> stackSupplier) {
       Stack<Integer> stack = stackSupplier.get();
        assertEquals(0, stack.size());
    }

    @ParameterizedTest
    @MethodSource("stackProvider")
    public void addingElementsToStackTest(Supplier<Stack<Integer>> stackSupplier) {
        Stack<Integer> stack = stackSupplier.get();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.size());
        assertEquals(5, stack.peek());
    }

    @ParameterizedTest
    @MethodSource("stackProvider")
    public void poppingElementsFromStackTest(Supplier<Stack<Integer>> stackSupplier) {
        Stack<Integer> stack = stackSupplier.get();

        stack.push(1);
        stack.push(2);
        Integer popped = stack.pop();

        assertEquals(2, popped);
        assertEquals(1, stack.size());
    }


}