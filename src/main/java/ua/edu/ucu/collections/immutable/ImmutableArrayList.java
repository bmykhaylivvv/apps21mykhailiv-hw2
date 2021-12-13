package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arrayList;
    private int length;
    public ImmutableArrayList(Object[] elements) {
        arrayList = Arrays.copyOf(elements, elements.length);
        this.length = elements.length;
    }

    public ImmutableArrayList() {
        arrayList = new Object[0];
        this.length = 0;
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

        Object[] newArray = new Object[this.length + c.length];

        int currentIndex = 0;
        for (int i = 0; i < index; i++) {
            newArray[currentIndex] = this.arrayList[i];
            currentIndex++;
        }

        for (int j = 0; j < c.length; j++) {
            newArray[currentIndex] = c[j];
            currentIndex++;
        }

        for (int k = index; k < this.length; k++) {
            newArray[currentIndex] = this.arrayList[k];
            currentIndex++;
        }


        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        return this.arrayList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = new Object[this.length - 1];

        for (int i = 0, j = 0; i < this.length; i++) {
            if (i == index) {
                continue;
            }

            newArray[j] = this.arrayList[i];
            j++;
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }

        this.arrayList[index] = e;
        return new ImmutableArrayList(this.arrayList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.length; i++) {
            if (this.arrayList[i].equals(e)){
                return i;
            }
        }

        throw new NoSuchElementException();    }

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
        return Arrays.copyOf(this.arrayList, this.length);
    }

    public static void main(String[] args) {
        ImmutableArrayList list = new ImmutableArrayList(new Object[] {1, 2, 3});
//        ImmutableList list1 = list.addAll(new Object[] {4, 4});
        ImmutableList list1 = list.addAll(0,  new Object[] {9, 9 ,9});
        ImmutableList list2 = list.add(1, 123);
        ImmutableList list3 = list.remove(2);
        ImmutableList list4 = list.set(2, 890);
        ImmutableList list5 = list.clear();
        ImmutableArrayList emptyList = new ImmutableArrayList();






        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println(Arrays.toString(list3.toArray()));
        System.out.println(Arrays.toString(list4.toArray()));
        System.out.println(list.indexOf(890));
        System.out.println(Arrays.toString(list5.toArray()));
        System.out.println(emptyList.isEmpty());




    }
}
