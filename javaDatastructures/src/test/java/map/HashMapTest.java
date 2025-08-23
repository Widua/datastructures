package map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    public void insertionTest(){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Four",4);
        map.put("Five",5);
        map.put("Six",6);
        map.put("Seven",7);


        assertEquals(7,map.size());
        assertEquals(3,map.get("Three"));
    }

    @Test
    public void deletionTest(){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Four",4);
        map.put("Five",5);
        map.put("Six",6);
        map.put("Seven",7);


        map.remove("Two");
        assertNull(map.get("Two"));
    }

    @Test
    public void replaceTest(){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Four",4);
        map.put("Five",5);
        map.put("Six",6);
        map.put("Seven",7);

        map.replace("Six",66);

        assertEquals(66,map.get("Six"));
    }


}