package com.hphothong.algorithms;

import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> singlyLinkedList;

    @Before
    public void setUp() {
        this.singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testSinglyLinkedListSize() {
        assertEquals(0, this.singlyLinkedList.size());
    }

    @Test
    public void testIsEmptySinglyLinkedList() {
        assertTrue(this.singlyLinkedList.isEmpty());
    }

    @Test
    public void testContainsSinglyLinkedList() {
        this.singlyLinkedList.add(1);
        assertTrue(this.singlyLinkedList.contains(1));
    }

    @Test
    public void testIteratorSinglyLinkedList() {
        this.singlyLinkedList.add(1);
        this.singlyLinkedList.add(2);
        this.singlyLinkedList.add(3);

        Iterator<Integer> iterator = this.singlyLinkedList.iterator();

        for (Integer i = 1; i < 4; i++) {
            Integer value = iterator.next();
            assertEquals(i, value);
        }
    }

    @Test
    public void testToArrayNoArgsSinglyLinkedList() {
        this.singlyLinkedList.add(1);
        Object[] array = this.singlyLinkedList.toArray();

        assertEquals(1, array[0]);
        assertEquals(Object[].class, array.getClass());
    }

    @Test (expected = NotImplementedException.class)
    public void testToArrayWithArgs() {
        Integer[] array = new Integer[10];
        this.singlyLinkedList.toArray(array);
    }

    @Test
    public void testAddSinglyLinkedList() {
        assertTrue(this.singlyLinkedList.add(1));
        assertTrue(this.singlyLinkedList.contains(1));
    }

    @Test
    public void testRemoveSinglyLinkedList() {
        this.singlyLinkedList.add(1);
        this.singlyLinkedList.add(2);

        assertTrue(this.singlyLinkedList.remove(2));
        assertFalse(this.singlyLinkedList.contains(2));
    }

    @Test
    public void testContainsAllSinglyLinkedList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        this.singlyLinkedList.add(1);
        this.singlyLinkedList.add(2);

        assertTrue(this.singlyLinkedList.containsAll(list));
    }

    @Test
    public void testAddAllSinglyLinkedList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        this.singlyLinkedList.addAll(list);

        assertTrue(this.singlyLinkedList.containsAll(list));
    }

    @Test
    public void testRemoveAllSinglyLinkedList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        this.singlyLinkedList.addAll(list);
        list.remove(0);
        this.singlyLinkedList.removeAll(list);

        assertFalse(this.singlyLinkedList.isEmpty());
        assertTrue(this.singlyLinkedList.remove(1));
    }

    @Test
    public void testRetainAllSinglyLinkedList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        this.singlyLinkedList.addAll(list);
        list.remove(0);
        this.singlyLinkedList.retainAll(list);

        assertFalse(this.singlyLinkedList.isEmpty());
        assertEquals(2, this.singlyLinkedList.size());
        assertFalse(this.singlyLinkedList.remove(1));
        assertTrue(this.singlyLinkedList.remove(2));
        assertTrue(this.singlyLinkedList.remove(3));
    }

    @Test
    public void testClearSinglyLinkedList() {
        this.singlyLinkedList.add(1);
        this.singlyLinkedList.add(2);

        this.singlyLinkedList.clear();

        assertEquals(0, this.singlyLinkedList.size());
    }
}
