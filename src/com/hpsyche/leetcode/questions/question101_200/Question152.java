package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/18
 */
public class Question152 {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int mMax=1;
        int mMin=1;
        for (int num : nums) {
            if (num < 0) {
                int temp = mMax;
                mMax = mMin;
                mMin = temp;
            }
            mMax = Math.max(mMax * num, num);
            mMin = Math.min(mMin * num, num);
            max = Math.max(max, mMax);
        }
        return max;
    }
}
