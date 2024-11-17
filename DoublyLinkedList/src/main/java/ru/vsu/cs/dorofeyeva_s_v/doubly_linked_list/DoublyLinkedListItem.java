package ru.vsu.cs.dorofeyeva_s_v.doubly_linked_list;

import lombok.Data;
import java.util.Objects;

@Data
public class DoublyLinkedListItem<T> {
    private DoublyLinkedListItem<T> previous;
    private DoublyLinkedListItem<T> next;
    private  T value;

    public DoublyLinkedListItem(T value, DoublyLinkedListItem<T> previous, DoublyLinkedListItem<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DoublyLinkedListItem<T> that = (DoublyLinkedListItem<T>) o;
        return Objects.equals(value, that.value);
    }
}