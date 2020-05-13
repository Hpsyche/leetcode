package com.hpsyche.leetcode.questions.question901_1000;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/5/13
 */
public class Question901 {
    private Stack<Integer> prices;
    private Stack<Integer> cache;
    public Question901() {
        prices=new Stack<>();
        cache=new Stack<>();
    }

    public int next(int price) {
        int count=1;
        while (!prices.isEmpty()&&prices.peek()<=price){
            prices.pop();
            count+=cache.pop();
        }
        prices.push(price);
        cache.push(count);
        return count;
    }
}
