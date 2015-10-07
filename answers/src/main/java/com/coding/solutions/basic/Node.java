package com.coding.solutions.basic;

/**
 * Node in a binary tree
 */
public class Node {
    Node left;
    Node right;
    int value;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}
