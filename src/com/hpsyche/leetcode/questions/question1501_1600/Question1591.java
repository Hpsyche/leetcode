package com.hpsyche.leetcode.questions.question1501_1600;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/24
 */
public class Question1591 {
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        return mergeSortNums(nums,0,nums.length-1);
    }

    private int mergeSortNums(int[] nums, int L, int R) {
        if(L==R){
            return 0;
        }
        int mid=L+((R-L)>>1);
        int left=mergeSortNums(nums,L,mid);
        int right=mergeSortNums(nums,mid+1,R);
        return left+right+merge(nums,L,mid,R);
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int count=0;
        int[] resArr=new int[r-l+1];
        int point=0;
        int p1=l;
        int p2=mid+1;
        while (p1<=mid&&p2<=r){
            if(nums[p1]>nums[p2]){
                //注意：是mid-p1+1
                count+=(mid-p1+1);
            }
            resArr[point++]=nums[p1]<=nums[p2]?nums[p1++]:nums[p2++];
        }
        while (p1<=mid){
            resArr[point++]=nums[p1++];
        }
        while (p2<=r){
            resArr[point++]=nums[p2++];
        }
        for(point=0;point<resArr.length;point++){
            nums[l+point]=resArr[point];
        }
        return count;
    }

    @Test
    public void test1(){
        int i = reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }
}
