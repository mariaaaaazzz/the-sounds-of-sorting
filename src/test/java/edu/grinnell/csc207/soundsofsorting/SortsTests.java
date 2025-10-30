package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }


    



    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        Integer[] arr = {5, 3, 8, 1, 4};
        Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));

        Integer[] arr1 = {1, 2, 3, 4, 5 };
        Sorts.bubbleSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {};
        Sorts.bubbleSort(arr2);
        assertTrue(sorted(arr2));
    }


    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);

        Integer[] arr = {7, 2, 5, 1, 3 };
        Sorts.insertionSort(arr);
        assertTrue(sorted(arr));


        Integer[] arr1 = {1, 2, 3, 4, 5 };
        Sorts.insertionSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {1};
        Sorts.insertionSort(arr2);
        assertTrue(sorted(arr2));
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);

        Integer[] arr = {9, 7, 3, 8, 2 };
        Sorts.selectionSort(arr);
        assertTrue(sorted(arr));

        Integer[] arr1 = {1, 2, 3, 4, 5 };
        Sorts.selectionSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {};
        Sorts.selectionSort(arr2);
        assertTrue(sorted(arr2));
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);

        Integer[] arr = {10, 1, 9, 3, 7 };
        Sorts.mergeSort(arr);
        assertTrue(sorted(arr));

        Integer[] arr1 = {1, 2, 3, 4, 5 };
        Sorts.mergeSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {7};
        Sorts.mergeSort(arr2);
        assertTrue(sorted(arr2));
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);

        Integer[] arr = {4, 2, 8, 6, 1 };
        Sorts.quickSort(arr);
        assertTrue(sorted(arr));

        Integer[] arr1 = {1, 2, 3, 4, 5 };
        Sorts.quickSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {};
        Sorts.quickSort(arr2);
        assertTrue(sorted(arr2));
    }
}