package com.hpsyche.leetcode.questions.question201_300;

import java.util.PriorityQueue;

/**
 * @author hpsyche
 * Create on 2020/6/15
 */
public class Question295 {
    private int count;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public Question295() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((x,y)->y-x);
    }

    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if((count&1)!=0){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if((count&1)==0){
            return (double)(maxHeap.peek()+minHeap.peek())/1;
        }else{
            return (double)maxHeap.peek();
        }
    }
}
