package com.coding.solutions.basic;

import com.google.common.collect.Sets;

import java.util.Set;

public class ParenthesesGenerator {
    public void combine(int n)
    {
        if(n > 0) {
            char[] chars = new char[2 * n];
            combine(0, n, 0, 0, chars);
        }
        return;
    }

    public void combine(int pos, int n, int open, int close, char[] chars)
    {
        if(close == n)
        {
            System.out.println(new String(chars));
            return;
        }
        else
        {
            if(open > close) {
                chars[pos] = ')';
                combine(pos + 1, n, open, close + 1, chars);
            }
            if(open < n) {
                chars[pos] = '(';
                combine(pos + 1, n, open + 1, close, chars);
            }
        }
    }

    public static void main(String[] args) {
        ParenthesesGenerator parenthesesGenerator = new ParenthesesGenerator();
        int n = 4;
        parenthesesGenerator.combine(n);
    }
}

