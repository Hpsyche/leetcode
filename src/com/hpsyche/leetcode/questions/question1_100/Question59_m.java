package com.hpsyche.leetcode.questions.question1_100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/6
 */
public class Question59_m {
    private Deque<Integer> queue;
    private Deque<Integer> maxQueue;
    public Question59_m() {
        queue=new ArrayDeque<>();
        maxQueue=new ArrayDeque<>();
    }

    public int max_value() {
        if(maxQueue.size()==0){
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty()&&value>maxQueue.peekLast()){
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if(queue.size()==0){
            return -1;
        }
        int remove = queue.pop();
        if(remove==maxQueue.peek()){
            maxQueue.poll();
        }
        return remove;
    }
}
