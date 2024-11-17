package ru.vsu.cs.dorofeyeva_s_v.doubly_linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListIntegerTest {
    @Test
    void addTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        assertEquals(list.getHead().getValue(), 0);
        assertEquals(list.getTail().getValue(), 0);
        assertEquals(list.size(), 1);
    }

    @Test
    void deleteTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.delete();
        assertEquals(list.getHead().getValue(), 0);
        assertEquals(list.getTail().getValue(), 1);
        assertEquals(list.size(), 2);
    }

    @Test
    void deleteByValueTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.delete(1);
        assertEquals(list.getHead().getValue(), 0);
        assertEquals(list.getTail().getValue(), 2);
        assertEquals(list.size(), 2);
    }

    @Test
    void deleteByValueTest_Exception() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertThrows(IllegalArgumentException.class, () -> list.delete(3));
    }

    @Test
    void findByValueTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(list.findByValue(1).getValue(), 1);
    }

    @Test
    void findByValueTest_Exception() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertThrows(IllegalArgumentException.class, () -> list.findByValue(3));
    }
}
