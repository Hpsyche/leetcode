package com.hpsyche.leetcode.questions.question1_100;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/30
 */
public class Question84_2 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                while (!stack.isEmpty() && heights[stack.peek()] == currHeight) {
                    stack.pop();
                }
                int currWidth;
                if (stack.isEmpty()) {
                    currWidth = i;
                } else {
                    currWidth = i - stack.peek() - 1;
                }
                res = Math.max(res, currHeight * currWidth);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int currHeight = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == currHeight) {
                stack.pop();
            }
            int currWidth;
            if (stack.isEmpty()) {
                currWidth = len;
            } else {
                currWidth = len - stack.peek() - 1;
            }
            res = Math.max(res, currHeight * currWidth);
        }
        return res;
    }

    @Test
    public void test1() {
        int[] h = new int[]{3, 4, 1, 5, 2};
        System.out.println(largestRectangleArea(h));;
    }
}

