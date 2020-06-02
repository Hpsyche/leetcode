package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/2
 */
public class Question215 {
    @Test
    public void test1() {
//        int[] test=new int[]{3,2,3,1,2,4,5,5,6};
        int[] test = new int[]{1};
        int kthLargest = findKthLargest(test, 1);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, k);
    }

    private int quickFind(int[] nums, int l, int r, int target) {
        int left = l;
        int right = r;
        int x = nums[l];
        while (left < right) {
            while (left < right && nums[right] <= x) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] >= x) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = x;
        if (left + 1 == target) {
            return nums[left];
        } else if (left + 1 > target) {
            return quickFind(nums, l, left - 1, target);
        } else {
            return quickFind(nums, left + 1, r, target);
        }
    }
}
