package ru.vsu.cs.dorofeyeva_s_v.doubly_linked_list;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Iterator;

@Data
@Accessors(chain = true)
public class DoublyLinkedList<T> implements Iterable<DoublyLinkedListItem<T>> {
    private DoublyLinkedListItem<T> head;
    private DoublyLinkedListItem<T> tail;
    private int size;

    public void add(T value){
        DoublyLinkedListItem<T> newItem = new DoublyLinkedListItem<>(value, null, null);
        if (head == null) {
            head = tail = newItem;
        } else {
            tail.setNext(newItem);
            newItem.setPrevious(tail);
            tail = newItem;
        }
        size++;
    }

    public DoublyLinkedListItem<T> delete(){
        if (head == null) {
            return null;
        }

        DoublyLinkedListItem<T> deletedItem = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
        }
        size--;
        return deletedItem;
    }

    public DoublyLinkedListItem<T> delete(T value){
        DoublyLinkedListItem<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    delete();
                }
                size--;
                return current;
            }
            current = current.getNext();
        }
        throw new IllegalArgumentException("Element with the specified value not found in the list: " + value);
    }

    public DoublyLinkedListItem<T> findByValue(T value){
        for (Iterator<DoublyLinkedListItem<T>> findingItem = iterator(); findingItem.hasNext();) {
            DoublyLinkedListItem<T> element = findingItem.next();
            if (element.getValue().equals(value)){
                return element;
            }
        }
        throw new IllegalArgumentException("Element with the specified value not found in the list: " + value);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<DoublyLinkedListItem<T>> iterator() {
        return new Iterator<DoublyLinkedListItem<T>>() {
            private DoublyLinkedListItem<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr.getNext() != null;
            }

            @Override
            public DoublyLinkedListItem<T> next() {
                curr = curr.getNext();
                return curr;
            }
        };
    }
}
