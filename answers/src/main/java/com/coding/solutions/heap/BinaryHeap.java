package com.coding.solutions.heap;

import java.util.ArrayList;

/**
 * Max heap implementation
 */
public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_HEAP_CAPACITY = 128;
    private ArrayList<T> nodes;
    private int heapSize;

    public void heapifyUp(int index) {
        int parentIndex = (int) Math.floor(index / 2);
        boolean isHeapPropertySatisfied = false;

        while (!isHeapPropertySatisfied && parentIndex < index) {
            T currentNode = nodes.get(index);
            T parentNode = nodes.get(parentIndex);
            if (currentNode.compareTo(parentNode) > 0) {
                nodes.set(index, parentNode);
                nodes.set(parentIndex, currentNode);
            } else {
                isHeapPropertySatisfied = true;
            }

            index = parentIndex;
            parentIndex = (int) Math.floor(index / 2);
        }
    }

    public void heapifyDown(int index) {
        if (index >= heapSize) {
            return;
        }
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        T currentNode = nodes.get(index);
        T leftChild = leftChildIndex < heapSize ? nodes.get(leftChildIndex) : null;
        T rightChild = rightChildIndex < heapSize ? nodes.get(rightChildIndex) : null;

        if (rightChild != null && rightChild.compareTo(currentNode) > 0 && rightChild.compareTo(leftChild) > 0) {
            nodes.set(index, rightChild);
            nodes.set(rightChildIndex, currentNode);
            heapifyDown(rightChildIndex);
        } else if (leftChild != null && leftChild.compareTo(currentNode) > 0) {
            nodes.set(leftChildIndex, currentNode);
            nodes.set(index, leftChild);
            heapifyDown(leftChildIndex);
        }

    }
}
