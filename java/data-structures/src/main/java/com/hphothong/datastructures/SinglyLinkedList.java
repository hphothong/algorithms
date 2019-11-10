package com.hphothong.algorithms;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Collection<T>, Iterable<T> {
    private SinglyLinkedListNode<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public int size() {
        int size = 0;
        SinglyLinkedListNode<T> node = this.head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean contains(Object o) {
        SinglyLinkedListNode<T> node = this.head;
        while (node != null) {
            if (node.getValue().equals(o)) {
                return true;
            } else {
                node = node.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator<T>(this, this.head);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        SinglyLinkedListNode<T> node = this.head;
        int rear = 0;
        while (node != null) {
            array[rear++] = node.getValue();
            node = node.getNext();
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new NotImplementedException();
    }

    @Override
    public boolean add(T t) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(t);
        if (this.head == null) {
            this.head = node;
        } else {
            SinglyLinkedListNode<T> currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.head == null) {
            return false;
        }
        if (this.head.getValue().equals(o)) {
            this.head = this.head.getNext();
            return true;
        }
        SinglyLinkedListNode<T> currentNode = this.head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getValue().equals(o)) {
                currentNode.setNext(currentNode.getNext().getNext());
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iterator = c.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            boolean success = this.remove(iterator.next());
            if (!success) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T value = iterator.next();
            if (!c.contains(value)) {
                this.remove(value);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    public class SinglyLinkedListIterator<T> implements Iterator<T> {
        private SinglyLinkedList<T> list;
        private SinglyLinkedListNode<T> currentNode;

        public SinglyLinkedListIterator(SinglyLinkedList<T> list, SinglyLinkedListNode<T> head) {
            this.list = list;
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode.getNext() != null;
        }

        @Override
        public T next() {
            T value = this.currentNode.getValue();
            this.currentNode = currentNode.getNext();
            return value;
        }

        @Override
        public void remove() {
            SinglyLinkedListNode<T> nextNode = this.currentNode.getNext();
            this.list.remove(this.currentNode.getValue());
            this.currentNode = nextNode;
        }
    }

    public class SinglyLinkedListNode<T> {
        private T value;
        private SinglyLinkedListNode<T> next;

        public SinglyLinkedListNode(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return this.value;
        }

        public SinglyLinkedListNode<T> getNext() {
            return this.next;
        }

        public void setNext(SinglyLinkedListNode<T> next) {
            this.next = next;
        }
    }
}