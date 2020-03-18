package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/18
 */
public class Question836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[1] < rec2[3] && rec2[1] < rec1[3] && rec1[0] < rec2[2] && rec1[2] > rec2[0];
    }

    @Test
    public void test1(){
        System.out.println(isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));
    }
}
