package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        this.length = elements.length;

        if (elements.length == 0) {
            this.head = null;
            this.tail = null;
        } else {
            Node previous = null;
            for (int i = 0; i < elements.length; i++) {
                Node node = new Node(elements[i]);
                node.setPrevious(previous); // set previous node as null for head node (first node)

                if (previous != null) {
                    previous.setNext(node);
                }
                previous = node;

                if (i == 0) {
                    this.head = node;
                }

                if (i == elements.length - 1) {
                    node.setNext(null); // set next node as null for tail node (the last one)
                    this.tail = node;
                }
            }
        }



    }

    public ImmutableLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] reservedArray = Arrays.copyOf(this.toArray(), this.length);
        Object[] newArray = new Object[this.length + c.length];

        int currentIndex = 0;
        for (int i = 0; i < index; i++) {
            newArray[currentIndex] = reservedArray[i];
            currentIndex++;
        }

        for (int j = 0; j < c.length; j++) {
            newArray[currentIndex] = c[j];
            currentIndex++;
        }

        for (int k = index; k < this.length; k++) {
            newArray[currentIndex] = reservedArray[k];
            currentIndex++;
        }

        return new ImmutableLinkedList(newArray);

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.length];

        Node currentNode = this.head;

        for (int i = 0; i < this.length; i++) {
            array[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return null;
    }

    public ImmutableLinkedList addLast(Object e) {
        return null;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return null;
    }

    public Object getFirst() {
        return null;
    }

    public Object getLast() {
        return null;
    }

    public ImmutableLinkedList removeFirst() {
        return null;
    }

    public ImmutableLinkedList removeLast() {
        return null;
    }

    public static void main(String[] args) {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[] {1, 2, 3});
//        ImmutableList list1 = list.addAll(new Object[] {4, 4});
        ImmutableList list1 = list.add(1, 4);

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list1.toArray()));

    }
}
