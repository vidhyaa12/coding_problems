package com.coding.solutions.basic;

/**
 * Created by vidhyaa on 10/29/15.
 */
public class SinglyLinkedListNode<T> implements Comparable<T> {
    private T value;
    private SinglyLinkedListNode<T> next;

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public SinglyLinkedListNode<T> getNext() {
        return next;
    }
    public void setNext(SinglyLinkedListNode<T> ref) {
        this.next = ref;
    }

    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}

