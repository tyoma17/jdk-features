package com.tyoma17.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedSetTest {

    private SortedSet<String> sortedSet;

    @BeforeEach
    void init() {
        sortedSet = new TreeSet<>(comparing(String::length));
        sortedSet.add("abc");
        sortedSet.add("ab");
        sortedSet.add("abcd");
        sortedSet.add("a");
    }

    @Test
    void first() {
        assertEquals("a", sortedSet.first());
    }

    @Test
    void last() {
        assertEquals("abcd", sortedSet.last());
    }

    @Test
    void headSet() {
        SortedSet<String> headSet = sortedSet.headSet("abc");
        assertThat(headSet).containsExactly("a", "ab");
    }

    @Test
    void tailSet() {
        SortedSet<String> tailSet = sortedSet.tailSet("abc");
        assertThat(tailSet).containsExactly("abc", "abcd");
    }

    @Test
    void subSet() {
        SortedSet<String> subSet = sortedSet.subSet("ab", "abcd");
        assertThat(subSet).containsExactly("ab", "abc");
    }

}