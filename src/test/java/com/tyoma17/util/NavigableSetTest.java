package com.tyoma17.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NavigableSetTest {

    private static final String A = "a";
    private static final String AB = "ab";
    private static final String ABC = "abc";
    private static final String ABCD = "abcd";
    private static final String ABCDE = "abcde";
    private static final String ABCDEF = "abcdef";

    private NavigableSet<String> navigableSet;

    @BeforeEach
    void init() {
        navigableSet = new TreeSet<>(comparing(String::length));
        navigableSet.add(ABC);
        navigableSet.add(AB);
        navigableSet.add(ABCD);
        navigableSet.add(A);
        navigableSet.add(ABCDEF);
        navigableSet.add(ABCDE);
    }

    @Test
    void higher() {

        String higher = navigableSet.higher(ABCDE);
        assertEquals(ABCDEF, higher);

        higher = navigableSet.higher(ABCDEF);
        assertNull(higher);
    }

    @Test
    void ceiling() {

        String ceiling = navigableSet.ceiling(ABCDE);
        assertEquals(ABCDE, ceiling);

        ceiling = navigableSet.ceiling(ABCDEF);
        assertEquals(ABCDEF, ceiling);
    }

    @Test
    void floor() {

        String floor = navigableSet.floor(AB);
        assertEquals(AB, floor);

        floor = navigableSet.floor(A);
        assertEquals(A, floor);
    }

    @Test
    void lower() {

        String lower = navigableSet.lower(AB);
        assertEquals(A, lower);

        lower = navigableSet.lower(A);
        assertNull(lower);
    }

    @Test
    void headSetWithInclusiveParameter() {

        NavigableSet<String> headSet = navigableSet.headSet(AB, false);
        assertThat(headSet).containsExactly(A);

        headSet = navigableSet.headSet(AB, true);
        assertThat(headSet).containsExactly(A, AB);
    }

    @Test
    void tailSetWithInclusiveParameter() {

        NavigableSet<String> tailSet = navigableSet.tailSet(ABCDE, false);
        assertThat(tailSet).containsExactly(ABCDEF);

        tailSet = navigableSet.tailSet(ABCDE, true);
        assertThat(tailSet).containsExactly(ABCDE, ABCDEF);
    }

    @Test
    void pollFirst() {

        assertEquals(6, navigableSet.size());
        String first = navigableSet.pollFirst();
        assertEquals(A, first);
        assertEquals(5, navigableSet.size());
    }

    @Test
    void pollLast() {

        assertEquals(6, navigableSet.size());
        String last = navigableSet.pollLast();
        assertEquals(ABCDEF, last);
        assertEquals(5, navigableSet.size());
    }

    @Test
    void subSetWithFromAndToInclusiveParameters() {

        NavigableSet<String> subSet = navigableSet.subSet(ABC, false, ABCD, false);
        assertTrue(subSet.isEmpty());

        subSet = navigableSet.subSet(ABC, true, ABCD, true);
        assertThat(subSet).containsExactly(ABC, ABCD);
    }
}
