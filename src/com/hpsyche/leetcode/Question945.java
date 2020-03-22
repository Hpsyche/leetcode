package com.hpsyche.leetcode;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/3/22
 */
public class Question945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count=0;
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                count+=(A[i-1]+1-A[i]);
                A[i]=A[i-1]+1;
            }
        }
        return count;
    }
}
