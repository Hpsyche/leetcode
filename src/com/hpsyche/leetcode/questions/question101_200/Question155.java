package com.hpsyche.leetcode.questions.question101_200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Question155() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek()<x?minStack.peek():x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
