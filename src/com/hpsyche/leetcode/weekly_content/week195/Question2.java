package com.hpsyche.leetcode.weekly_content.week195;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/28
 */
public class Question2 {
    public boolean canArrange(int[] arr, int k) {
        int[] flags = new int[k];
        for (int num : arr) {
            if(num<0){
                int temp = (-num) / k;
                if ((-num)%k != 0) {
                    temp += 1;
                }
                temp *= k;
                num = num + temp;
            }
            int yuu = k - num % k;
            if (yuu == k) {
                yuu = 0;
            }
            if (flags[yuu]>0) {
                flags[yuu]-=1;
            } else {
                flags[num % k]+=1;
            }
        }
        for (int i : flags) {
            if (i>0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        int[] arr=new int[]{1,2,3,4,5,10,6,7,8,9};
//        int[] arr=new int[]{-4,-7,5,2,9,1,10,4,-8,-3};
//        int[] arr=new int[]{-1,1,-2,2,-3,3,-4,4};
        System.out.println(canArrange(arr,5));
//        System.out.println(-5 / 3);
//        System.out.println(-5 % 3);
    }
}
