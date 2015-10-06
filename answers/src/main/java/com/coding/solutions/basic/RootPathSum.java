package com.coding.solutions.basic;

/**
 * Count the number of paths from the root to any node that sum to a given value
 */
public class RootPathSum {
    public RootPathSum(Node n, int sum) {

    }

    public int countPaths(Node n, int sum, int count) {
        if (n != null) {
            sum = sum - n.value;

            if (sum == 0) {
                count ++;
            }

            countPaths(n.left, sum, count);
            countPaths(n.right, sum, count);
        }

        return count;
    }
}
