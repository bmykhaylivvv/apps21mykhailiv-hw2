package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;
    public Queue() {
        this.linkedList = new ImmutableLinkedList();
    }
    public Object peek() {
        return this.linkedList.getFirst();
    }

    public Object dequeue() {
        Object dequeuedElement = this.peek();
        this.linkedList = this.linkedList.removeFirst();
        return dequeuedElement;
    }

    public void enqueue(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }
}
