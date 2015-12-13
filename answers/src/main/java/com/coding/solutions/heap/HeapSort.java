package com.coding.solutions.heap;

import java.util.Arrays;
import java.util.List;

/**
 * Sort a list in ascending order using a max heap based algorithm
 */

public class HeapSort<T extends Comparable<T>> {
    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BinaryHeap<T> binaryHeap = new BinaryHeap(list.size());
        binaryHeap.addAll(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            list.set(i, binaryHeap.pop());
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(11, 20, 209, 487, 74, 1, 10, 5);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(input);
        System.out.println(Arrays.toString(input.toArray()));
    }
}
