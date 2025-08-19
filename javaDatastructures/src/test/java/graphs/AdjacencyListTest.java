package graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest {

    public void setupGraph(Graph graph) {
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 0, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 3, 1);
        graph.addEdge(3, 1, 2);
    }

    static Stream<Supplier<Graph>> graphProvider() {
        return Stream.of(AdjacencyList::new, AdjacencyMatrix::new);
    }


    @ParameterizedTest
    @MethodSource("graphProvider")
    public void adjacentTest(Supplier<Graph> graphSupplier) {
        Graph graph = graphSupplier.get();
        setupGraph(graph);

        assertTrue(graph.adjacent(3, 1));
        assertFalse(graph.adjacent(3, 0));
    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    public void neighboursTest(Supplier<Graph> graphSupplier) {

        Graph graph = graphSupplier.get();
        setupGraph(graph);

        int[] neighbours = graph.neighbors(0);
        Arrays.sort(neighbours);

        assertArrayEquals(new int[]{1, 2, 3}, neighbours);

    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    public void weightUpdateTest(Supplier<Graph> graphSupplier) {
        Graph graph = graphSupplier.get();
        setupGraph(graph);

        int weight_0_1 = graph.getEdgeWeight(0, 1);
        int weight_0_2 = graph.getEdgeWeight(0, 2);
        graph.setEdgeWeight(1, 0, 2);
        int weight_1_0 = graph.getEdgeWeight(1, 0);

        assertEquals(1, weight_0_1);
        assertEquals(3, weight_0_2);
        assertEquals(2, weight_1_0);
    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    public void weightRemovalTest(Supplier<Graph> graphSupplier) {
        Graph graph = graphSupplier.get();
        setupGraph(graph);

        graph.removeEdge(1, 3);

        int weight_1_3 = graph.getEdgeWeight(1, 3);

        assertEquals(-1, weight_1_3);
    }

}