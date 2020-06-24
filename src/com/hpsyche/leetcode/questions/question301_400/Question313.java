package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author hpsyche
 * Create on 2020/6/24
 */
public class Question313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> heap=new PriorityQueue<>();
        long curr=1;
        for(int i=1;i<n;i++){
            for(int prime:primes){
                heap.add(prime*curr);
            }
            curr=heap.poll();
            while(!heap.isEmpty()&&curr==heap.peek()) {
                heap.poll();
            }
        }
        return (int)curr;
    }

    @Test
    public void test1(){
        int[] temp=new int[]{2,7,13,19};
        nthSuperUglyNumber(12,temp);
    }
}
