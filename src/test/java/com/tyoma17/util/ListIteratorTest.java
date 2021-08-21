package com.tyoma17.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ListIteratorTest {

    private List<Integer> list;
    private ListIterator<Integer> listIterator;

    @BeforeEach
    void init() {

        list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }

        listIterator = list.listIterator();
    }

    @Test
    void add() {

        listIterator.add(10);
        assertThat(list).containsExactly(10, 1, 2, 3);

        listIterator.next();
        listIterator.next();
        listIterator.add(20);
        assertThat(list).containsExactly(10, 1, 2, 20, 3);
    }

    @Test
    void hasPrevious() {

        assertFalse(listIterator.hasPrevious());

        listIterator.next();
        assertTrue(listIterator.hasPrevious());
    }

    @Test
    void previous() {

        assertEquals(listIterator.next(), listIterator.previous());

        listIterator.next();
        listIterator.next();
        assertEquals(2, listIterator.previous());
        assertEquals(1, listIterator.previous());
    }

    @Test
    void nextIndex() {

        assertEquals(0, listIterator.nextIndex());
        listIterator.next();
        assertEquals(1, listIterator.nextIndex());
    }

    @Test
    void previousIndex() {

        assertEquals(-1, listIterator.previousIndex());
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());
    }

    @Test
    void set() {

        listIterator.next();
        listIterator.next();

        listIterator.set(10);
        assertThat(list).containsExactly(1, 10, 3);
    }
}
