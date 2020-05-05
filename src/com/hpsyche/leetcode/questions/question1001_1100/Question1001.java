package com.hpsyche.leetcode.questions.question1001_1100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/5
 */
public class Question1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int curr=m+n-1;
        m--;
        n--;
        while (m>=0&&n>=0){
            A[curr--]=A[m]>B[n]?A[m--]:B[n--];
        }
        while (n>=0){
            A[curr--]=B[n--];
        }
        for(int i:A){
            System.out.println(i);
        }
    }

    @Test
    public void test1(){
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
//        merge(new int[]{0},0,new int[]{1},1);
    }
}
