package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/3
 */
public class Question121 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len=prices.length;
        int[] left=new int[len];
        int leftMin=Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            leftMin=Math.min(leftMin,prices[i]);
            left[i]=leftMin;
        }
        int[] right=new int[len];
        int rightMax=Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--){
            rightMax=Math.max(rightMax,prices[i]);
            right[i]=rightMax;
        }
        int resMax=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            resMax=Math.max(right[i]-left[i],resMax);
        }
        return resMax;
    }

    @Test
    public void test1(){
//        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,5,4,2,1}));
    }
}
