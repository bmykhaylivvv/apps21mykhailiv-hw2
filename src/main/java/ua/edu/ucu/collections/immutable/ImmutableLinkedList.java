package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
                node.setPrevious(previous); // set previous node as
                                            // null for head node (first node)

                if (previous != null) {
                    previous.setNext(node);
                }
                previous = node;

                if (i == 0) {
                    this.head = node;
                }

                if (i == elements.length - 1) {
                    node.setNext(null); // set next node as
                                        // null for tail node (the last one)
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
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] array = Arrays.copyOf(this.toArray(), this.length);
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] reservedArray = Arrays.copyOf(this.toArray(), this.length);
        Object[] newArray = new Object[this.length - 1];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                continue;
            }

            newArray[j] = reservedArray[i];
            j++;
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] array = Arrays.copyOf(this.toArray(), this.length);
        array[index] = e;

        return new ImmutableLinkedList(array);
    }

    @Override
    public int indexOf(Object e) {
        Object[] array = Arrays.copyOf(this.toArray(), this.length);
        for (int i = 0; i < this.length; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] cleanedArray = new Object[this.length];
        return new ImmutableLinkedList(cleanedArray);
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
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
        Object[] reservedArray = Arrays.copyOf(this.toArray(), this.length);
        Object[] newArray = new Object[this.length + 1];

        int j = 0;
        newArray[0] = e;
        for (int i = 1; i <= this.length; i++) {
            newArray[i] = reservedArray[j];
            j++;
        }
        this.length++;
        return new ImmutableLinkedList(newArray);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] reservedArray = Arrays.copyOf(this.toArray(), this.length);
        Object[] newArray = new Object[this.length + 1];

        newArray[this.length] = e;
        for (int i = 0; i < this.length; i++) {
            newArray[i] = reservedArray[i];
        }
        return new ImmutableLinkedList(newArray);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }

        return this.head.getValue();
    }

    public Object getLast() {
        if (this.tail == null) {
            throw new IndexOutOfBoundsException();
        }

        return this.tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = Arrays.copyOfRange(this.toArray(), 1, this.length);
        return new ImmutableLinkedList(newArray);
    }

    public ImmutableLinkedList removeLast() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException();
        }


        Object[] newArray = Arrays.copyOf(this.toArray(), this.length - 1);
        return new ImmutableLinkedList(newArray);
    }
}
