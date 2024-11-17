package ru.vsu.cs.dorofeyeva_s_v.doubly_linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListStringTest {
    @Test
    void addTest() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        assertEquals(list.getHead().getValue(), "A");
        assertEquals(list.getTail().getValue(), "A");
        assertEquals(list.size(), 1);
    }

    @Test
    void deleteTest() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.delete();
        assertEquals(list.getHead().getValue(), "A");
        assertEquals(list.getTail().getValue(), "B");
        assertEquals(list.size(), 2);
    }

    @Test
    void deleteByValueTest() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.delete("B");
        assertEquals(list.getHead().getValue(), "A");
        assertEquals(list.getTail().getValue(), "C");
        assertEquals(list.size(), 2);
    }

    @Test
    void deleteByValueTest_Exception() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThrows(IllegalArgumentException.class, () -> list.delete("D"));
    }

    @Test
    void findByValueTest() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(list.findByValue("B").getValue(), "B");
    }

    @Test
    void findByValueTest_Exception() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThrows(IllegalArgumentException.class, () -> list.findByValue("D"));
    }
}
