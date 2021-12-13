package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest extends TestCase {
    ImmutableArrayList filledList;
    ImmutableArrayList emptyList;

    public void setUp() throws Exception {
        super.setUp();
        filledList = new ImmutableArrayList(new Object[] {1, 2, 3});
        emptyList = new ImmutableArrayList();
    }

    public void testAdd1() {
        Object[] expResult = new Object[] {1, 2, 3, 100};

        ImmutableList actualResult = filledList.add(100);

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testAdd2() {
        Object[] expResult = new Object[] {100, 1, 2, 3};

        ImmutableList actualResult = filledList.add(0, 100);

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testAddAll1() {
        Object[] expResult = new Object[] {1, 2, 3, 100, 200};

        ImmutableList actualResult = filledList.addAll(new Object[] {100, 200});

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testAddAll2() {
        Object[] expResult = new Object[] {100, 200, 1, 2, 3};

        ImmutableList actualResult = filledList.addAll(0, new Object[] {100, 200});

        assertArrayEquals(expResult, actualResult.toArray());
    }


    public void testGet() {
        Object expResult = 1;

        Object actualResult = filledList.get(0);

        assertEquals(expResult, actualResult);
    }

    public void testRemove() {
        Object[] expResult = new Object[] {2, 3};

        ImmutableList actualResult = filledList.remove(0);

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testSet() {
        Object[] expResult = new Object[] {100, 2, 3};

        ImmutableList actualResult = filledList.set(0, 100);

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testIndexOf() {
        int expResult = 0;

        int actualResult = filledList.indexOf(1);

        assertEquals(expResult, actualResult);
    }

    public void testSize() {
        int expResult = 3;

        int actualResult = filledList.size();

        assertEquals(expResult, actualResult);
    }

    public void testClear() {
        Object[] expResult = new Object[] {null, null, null};

        ImmutableList actualResult = filledList.clear();

        assertArrayEquals(expResult, actualResult.toArray());
    }

    public void testIsEmpty() {
        boolean expResult1 = false;
        boolean expResult2 = true;

        boolean actualResult1 = filledList.isEmpty();
        boolean actualResult2 = emptyList.isEmpty();

        assertEquals(expResult1, actualResult1);
        assertEquals(expResult2, actualResult2);

    }

    public void testToArray() {
        Object[] expResult = new Object[] {1, 2, 3};

        Object[] actualResult = filledList.toArray();

        assertArrayEquals(expResult, actualResult);

    }
}