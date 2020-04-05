package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/4
 */
public class Question42 {
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int maxLeft=0;
        for(int i=1;i<height.length;i++){
            left[i]=Math.max(height[i-1],maxLeft);
            maxLeft=left[i];
        }
        int maxRight=0;
        for(int i=height.length-2;i>=0;i--){
            right[i]=Math.max(height[i+1],maxRight);
            maxRight=right[i];
        }
        int count=0;
        for(int i=1;i<height.length-1;i++){
            int minSubHeight=Math.min(left[i],right[i])-height[i];
            count+= Math.max(minSubHeight, 0);
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
