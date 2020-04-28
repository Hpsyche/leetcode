package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/28
 */
public class Question88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr=m+n-1;
        m--;
        n--;
        while (m>=0&&n>=0){
            nums1[curr--]=nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        while (m>=0){
            nums1[curr--]=nums1[m--];
        }
        while (n>=0){
            nums1[curr--]=nums2[n--];
        }
        for(int i:nums1){
            System.out.println(i);
        }
    }

    @Test
    public void test1(){
//        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        merge(new int[]{7,8,9,0,0,0},3,new int[]{2,5,6},3);
    }
}
