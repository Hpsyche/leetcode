package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/17
 */
public class Question34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums.length==0){
            return res;
        }
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if(nums[mid]==target){
                r=mid-1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(l<nums.length&&nums[l]==target) {
            res[0] = l;
        }
        l=0;
        r=nums.length-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if(nums[mid]==target){
                l=mid+1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(r>=0&&nums[r]==target) {
            res[1] = r;
        }
        return res;
    }


    @Test
    public void test(){
        int[] ints = searchRange(new int[]{1}, 0);
        for(int i:ints){
            System.out.println(i);
        }

    }
}
