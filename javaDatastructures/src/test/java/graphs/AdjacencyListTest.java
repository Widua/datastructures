package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest {


    private AdjacencyList list = new AdjacencyList();

    @BeforeEach
    public void setupGraph(){
        list = new AdjacencyList();
        list.addVertex(0,1);
        list.addVertex(1,2);
        list.addVertex(2,3);
        list.addVertex(3,4);

        list.addEdge(0,1,1);
        list.addEdge(1,0,1);
        list.addEdge(2,3,1);
        list.addEdge(3,2,1);
        list.addEdge(0,2,3);
        list.addEdge(0,3,1);
        list.addEdge(3,1,2);
    }


    @Test
    public void adjacentTest(){

        assertTrue(list.adjacent(3,1));
        assertFalse(list.adjacent(3,0));
    }

    @Test
    public void neighboursTest(){

        int[] neighbours = list.neighbors(0);
        Arrays.sort(neighbours);

        assertArrayEquals(new int[]{1,2,3},neighbours);

    }

}