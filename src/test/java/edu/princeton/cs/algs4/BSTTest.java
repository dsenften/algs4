package edu.princeton.cs.algs4;

import ch.ffhs.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
class BSTTest {

    private BST<Integer, Integer> searchTree;

    @BeforeEach
    void setup() {
        searchTree = new BST<>();
        List<Integer> list = FileUtils.getIntegersFrom("100ints.txt");
        for (int key = 0; key < list.size(); key++) {
            searchTree.put(list.get(key), key);
        }
    }

    @Test
    void size() {
        BST<String, Integer> tree = new BST<>();
        assertEquals(0, tree.size());
        assertEquals(100, searchTree.size());
    }

    @Test
    void contains() {
        assertTrue(searchTree.contains(451074));
        assertFalse(searchTree.contains(4711));
        Exception exception = assertThrows(NullPointerException.class,
                () -> searchTree.contains(null));
    }

    @Test
    void get() {
        assertEquals(9, searchTree.get(287381));
        Exception exception = assertThrows(NullPointerException.class,
                () -> searchTree.get(null));
    }

    @Test
    void height() {
        assertEquals(11, searchTree.height());
    }
}
