package homework.sort;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

public class IntArrayTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private int[] array;
    private int[] emptyArray;

    @Before
    public void init() {
        array = new int[]{4, 3, 2, 5, 1};
        emptyArray = new int[]{};
    }

    @Test
    public void bubbleSortShouldReturnSortedArray() {
        final int[] actual = new BubbleSort().sortIntArray(array);
        final int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortShouldReturnSortedArray() {
        final int[] actual = new SelectionSort().sortIntArray(array);
        final int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortShouldReturnSortedArray() {
        final int[] actual = new InsertSort().sortIntArray(array);
        final int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleSortShouldReturnEmptyArray() {
        final int[] actual = new BubbleSort().sortIntArray(emptyArray);
        final int[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void selectionSortShouldReturnEmptyArray() {
        final int[] actual = new SelectionSort().sortIntArray(emptyArray);
        final int[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void insertSortShouldReturnEmptyArray() {
        final int[] actual = new InsertSort().sortIntArray(emptyArray);
        final int[] expected = {};
        assertArrayEquals(expected, actual);
    }

}