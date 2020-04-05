package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/12
 */
public class Question495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res=duration*timeSeries.length;
        for(int i=0;i<timeSeries.length-1;i++){
            if((timeSeries[i+1]-timeSeries[i])<duration){
                res-=(duration-(timeSeries[i+1]-timeSeries[i]));
            }
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(findPoisonedDuration(new int[]{1,2},2));
    }
}
