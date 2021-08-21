package com.tyoma17.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    private List<Integer> list;
    private Iterator<Integer> iterator;

    @BeforeEach
    void init() {

        list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }

        iterator = list.iterator();
    }

    @Test
    void hasNext() {

        assertTrue(iterator.hasNext());

        list.clear();
        assertFalse(iterator.hasNext());
    }

    @Test
    void next() {

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void remove() {

        assertThrows(IllegalStateException.class, iterator::remove);

        iterator.next();
        iterator.remove();

        assertEquals(2, list.size());
    }

    @Test
    void forEachRemaining() {

        List<Integer> list2 = new ArrayList<>();
        iterator.forEachRemaining(i -> list2.add(i * 2));
        assertThat(list2).containsExactly(2, 4, 6);
    }
}
