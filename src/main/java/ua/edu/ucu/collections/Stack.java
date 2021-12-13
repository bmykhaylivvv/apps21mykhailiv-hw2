package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList linkedList;
    public Stack() {
        this.linkedList = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }

    public Object pop() {
        Object poppedElement = this.linkedList.getLast();
        this.linkedList = this.linkedList.removeLast();
        return poppedElement;
    }

    public Object peek() {
        return this.linkedList.getLast();
    }
}
