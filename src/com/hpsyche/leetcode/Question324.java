package com.hpsyche.leetcode;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/3/23
 */
public class Question324 {
    public void wiggleSort(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        int[] smaller=new int[len%2==0?len/2:(len/2+1)];
        int[] bigger=new int[len/2];
        System.arraycopy(nums,0,smaller,0,smaller.length);
        System.arraycopy(nums,smaller.length,bigger,0,bigger.length);
        int i=0;
        for(;i<len/2;i++){
            nums[2*i]=smaller[smaller.length-1-i];
            nums[2*i+1]=bigger[len/2-1-i];
        }
        if(len%2!=0){
            nums[2*i]=smaller[smaller.length-1-i];
        }
    }
}
