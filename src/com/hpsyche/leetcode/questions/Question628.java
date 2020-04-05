package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/3/10
 */
public class Question628 {
    public int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int maxMin=Math.min(Math.min(max1,max2),max3);
            if(nums[i]>maxMin){
                if(max1==maxMin){
                    max1=nums[i];
                }else if(max2==maxMin){
                    max2=nums[i];
                }else if(max3==maxMin){
                    max3=nums[i];
                }
            }
            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }else if(nums[i]<min2){
                min2=nums[i];
            }
        }
        int maxNum=Math.max(Math.max(max1,max2),max3);
        return Math.max(max1*max2*max3,maxNum*min1*min2);
    }
}
