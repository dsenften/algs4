package edu.princeton.cs.algs4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STTest {
    private ST<String, Integer> symbolTable;

    @BeforeEach
    void setup() {
        symbolTable = new ST<>();

        String[] values = {
                "S", "E", "A", "R", "C", "H", "E",
                "X", "A", "M", "P", "L", "E" };
        for (int key = 0; key < values.length; key++) {
            symbolTable.put(values[key], key);
        }
    }

    @Test
    void remove() {
        assertTrue(symbolTable.contains("X"));
        symbolTable.remove("X");
        assertFalse(symbolTable.contains("X"));
    }

    @Test
    void contains() {
        assertTrue(symbolTable.contains("X"));
        assertFalse(symbolTable.contains("B"));
    }

    @Test
    void size() {
        assertEquals(10, symbolTable.size());
    }

    @Test
    void isEmpty() {
        assertFalse(symbolTable.isEmpty());
        symbolTable = new ST<>();
        assertTrue(symbolTable.isEmpty());
    }

}
