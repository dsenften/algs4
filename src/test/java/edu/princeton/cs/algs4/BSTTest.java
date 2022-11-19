package edu.princeton.cs.algs4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
class BSTTest {

    private static final String NULL_MESSAGE = "key is marked non-null but is null";

    private BST<Integer, Integer> searchTree;

    @BeforeEach
    void setup() {
        searchTree = new BST<>();
        int[] values = {
                324110, -442472, 626686, -157678, 508681,
                123414, -77867, 155091, 129801, 287381,
                604242, 686904, -247109, 77867, 982455,
                -210707, -922943, -738817, 85168, 855430};
        for (int key = 0; key < values.length; key++) {
            searchTree.put(key, values[key]);
        }
    }

    @Test
    void size() {
        BST<String, Integer> tree = new BST<>();
        assertEquals(0, tree.size());
        assertEquals(20, searchTree.size());
    }

    @Test
    void contains() {
        assertTrue(searchTree.contains(1));
        assertFalse(searchTree.contains(4711));
        Exception exception = assertThrows(NullPointerException.class,
                () -> searchTree.contains(null));
        assertEquals(NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void get() {
        assertEquals(324110, searchTree.get(0));
        Exception exception = assertThrows(NullPointerException.class,
                () -> searchTree.get(null));
        assertEquals(NULL_MESSAGE, exception.getMessage());
    }
}
