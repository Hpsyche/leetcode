package com.hpsyche.leetcode.questions.question201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question225 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public Question225() {
        queue1 =new LinkedList<>();
        queue2 =new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp= queue1;
        queue1 = queue2;
        queue2 =temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }
}
