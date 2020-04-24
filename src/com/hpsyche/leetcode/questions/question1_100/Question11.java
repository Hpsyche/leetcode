package com.hpsyche.leetcode.questions.question1_100;

/**
 * @author hpsyche
 * Create on 2020/4/10
 */
public class Question11 {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int min=Math.min(height[left],height[right]);
            max=Math.max(min*(right-left),max);
            //小的那边移动
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
