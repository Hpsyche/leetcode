package com.hpsyche.leetcode.questions.question701_800;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/11
 */
public class Question739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int len=T.length;
        int[] result=new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int pre=stack.pop();
                result[pre]=i-pre;
            }
            stack.push(i);
        }
        return result;
    }
}
