package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/27
 */
public class Question84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight=heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight=Math.min(minHeight,heights[j]);
                maxArea=Math.max(minHeight*(j-i+1),maxArea);
            }
        }
        return maxArea;
    }
    public int largestRectangleArea2(int[] heights) {
        Stack< Integer > stack = new Stack <> ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    @Test
    public void test(){
        System.out.println(largestRectangleArea2(new int[]{1,2,3,4,5,6}));;
    }
}
