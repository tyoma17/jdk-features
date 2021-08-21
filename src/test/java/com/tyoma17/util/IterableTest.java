package com.tyoma17.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IterableTest {

    private Iterable<Integer> iterable;

    @BeforeEach
    void init() {

        iterable = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            ((List)iterable).add(i);
        }
    }

    @Test
    void iterator() {
        assertNotNull(iterable.iterator());
    }
}
