package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/4/28
 */
public class Question85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[] height=new int[n];
        int maxArea=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }
            maxArea=Math.max(maxArea,helper(height));
        }
        return maxArea;
    }

    private int helper(int[] height) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for (int i = 0; i < height.length; i++) {
            while (stack.peek()!=-1&&height[stack.peek()]>=height[i]){
                maxArea=Math.max(maxArea,height[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            maxArea=Math.max(maxArea,height[stack.pop()]*(height.length-stack.peek()-1));
        }
        return maxArea;
    }

    @Test
    public void test1(){
        char[][] chars=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
//        char[][] chars=new char[][]{
//                {'1','0'}
//        };
        System.out.println(maximalRectangle(chars));
    }
}
