package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/16
 */
public class Question915 {
    public int partitionDisjoint(int[] A) {
        int leftMax=A[0],currMax=A[0],index=0;
        for(int i=1;i<A.length;i++){
            if(leftMax<A[i]){
                currMax=Math.max(currMax,A[i]);
            }else if(leftMax>A[i]){
                index=i;
                leftMax=currMax;
            }
        }
        return index+1;
    }

    @Test
    public void test1(){
        System.out.println(partitionDisjoint(new int[]{1,1,1,1,1}));
    }
}
