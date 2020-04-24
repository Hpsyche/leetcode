package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/25
 */
public class Question153 {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int mid=(l+r)>>1;
            if(nums[r]>nums[mid]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }

    @Test
    public void test1(){
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
