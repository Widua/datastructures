package cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {

    @Test
    public void updateTest(){
        LRU<String,Integer> lru = new LRU<>(3);

        lru.update("One",1);
        lru.update("Two",2);
        lru.update("Three",3);
        lru.update("Four",4);
        lru.update("One",11);
        lru.update("Five",5);
        lru.update("Six",6);

        assertEquals(5,lru.get("Five"));
        assertEquals(11,lru.get("One"));
        assertNull(lru.get("Fourteen"));
        assertNull(lru.get("Two"));
    }

}