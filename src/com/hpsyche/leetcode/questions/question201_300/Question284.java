package com.hpsyche.leetcode.questions.question201_300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/6/17
 */
public class Question284 implements Iterator<Integer>{
    Queue<Integer> queue;
    public Question284(Iterator<Integer> iterator) {
        // initialize any member here.
        queue =new LinkedList<>();
        while (iterator.hasNext()){
            queue.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
