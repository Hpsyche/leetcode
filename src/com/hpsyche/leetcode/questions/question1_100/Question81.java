package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/26
 */
public class Question81 {
    public boolean search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if(nums[mid]==nums[right]){
                right--;
                continue;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    @Test
    public void test1(){
        System.out.println(search(new int[]{3,1,1},3));
    }
}
