package com.hpsyche.leetcode.questions.question201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question225_2 {
    Queue<Integer> queue1;

    /** Initialize your data structure here. */
    public Question225_2() {
        queue1 =new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        int size=queue1.size();
        while (size>1){
            queue1.add(queue1.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
