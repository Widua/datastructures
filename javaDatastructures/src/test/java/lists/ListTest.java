package lists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;


class ListTest {

    static Stream<Supplier<List<Integer>>> listProvider(){
        return Stream.of(
                SingleLinkedList::new,
                DoublyLinkedList::new,
                ArrayList::new
        );
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    public void addingElementsToLinkedList(Supplier<List<Integer>> listSupplier){
        List<Integer> list = listSupplier.get();
        list.add(1);
        list.add(2);
        assertEquals(1,list.get(0));
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    public void sizeTest(Supplier<List<Integer>> listSupplier){
        List<Integer> list = listSupplier.get();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(4,list.size());
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    public void toStringTest(Supplier<List<Integer>> listSupplier){
        List<Integer> list = listSupplier.get();

        list.add(8);
        list.add(2);
        list.add(5);
        list.add(10);

        assertEquals("[8, 2, 5, 10]",list.toString());
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    public void deletionTest(Supplier<List<Integer>> listSupplier){
        List<Integer> list = listSupplier.get();

        list.add(0);
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        list.delete(1);

        assertEquals(10,list.get(1));
        assertEquals("[0, 10, 15, 20]",list.toString());
    }

}