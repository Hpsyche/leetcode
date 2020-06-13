package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/6/13
 */
public class Question279 {
    Map<Integer,Integer> map=new HashMap<>();
    public int numSquares(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if(n==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++) {
            min=Math.min(min,numSquares(n-i*i)+1);
        }
        map.put(n,min);
        return min;
    }

    @Test
    public void test1(){
        numSquares(13);
        System.out.println(numSquares(13));
    }
}
