package com.hpsyche.leetcode.jianzhi;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/30
 */
public class Question09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Question09() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        if(stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
