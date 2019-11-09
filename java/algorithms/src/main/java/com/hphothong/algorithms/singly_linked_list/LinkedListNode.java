package com.hphothong.algorithms.singly_linked_list;

public class LinkedListNode<T> {
    private LinkedListNode<T> next;
    private T value;

    public LinkedListNode() {
    }

    public LinkedListNode(T value) {
        this.value = value;
    }

    public LinkedListNode(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}