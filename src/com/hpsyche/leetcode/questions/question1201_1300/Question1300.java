package com.hpsyche.leetcode.questions.question1201_1300;

/**
 * @author hpsyche
 * Create on 2020/6/14
 */
public class Question1300 {
    public int findBestValue(int[] arr, int target) {
        int left=0;
        int right=0;
        for(int num:arr){
            right=Math.max(right,num);
        }
        while (left<right){
            int mid=left+((right-left)>>1);
            int sum=calculateSum(arr,mid);
            if(sum<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        int sum1=calculateSum(arr,left-1);
        int sum2=calculateSum(arr,left);
        if(Math.abs(target-sum1)<=Math.abs(target-sum2)){
            return left-1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum=0;
        for(int num:arr){
            sum+=Math.min(num,threshold);
        }
        return sum;
    }
}
