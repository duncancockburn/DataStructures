package DataStructures.HashMapCustomOnly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    HashMap<String, Number> testMap = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        testMap.add("Duncan", 22);
        testMap.add("Andrew", 20);
        testMap.add("Hannah", 24);


    }

    @Test
    public void add() {
        testMap.add(("Duncan"), 22);
        assertNotNull(testMap.find("Duncan"));
    }

    @Test
    public void remove() {
        testMap.remove("Hannah");
        assertNull(testMap.find("Hannah"));
    }

    @Test
    public void find() {
        assertEquals(22, testMap.find("Duncan"));
    }
}