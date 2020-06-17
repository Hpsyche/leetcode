package com.hpsyche.leetcode.questions.question1001_1100;

/**
 * @author hpsyche
 * Create on 2020/6/17
 */
public class Question1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res=Integer.MIN_VALUE;
        int prev= A[0];
        for (int i = 1; i < A.length; i++) {
            res=Math.max(res,prev+A[i]-i);
            prev=Math.max(prev,A[i]+i);
        }
        return res;
    }
}
