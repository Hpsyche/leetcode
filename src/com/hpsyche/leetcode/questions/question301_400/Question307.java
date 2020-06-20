package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/6/20
 */
public class Question307 {
    private int[] sum;
    public Question307(int[] nums) {
        int len=nums.length;
        sum=new int[len];
        int curr=0;
        for (int i = 0; i < len; i++) {
            curr+=nums[i];
            sum[i]=curr;
        }
    }

    public void update(int i, int val) {
        int prev=i>0?sum[i]-sum[i-1]:sum[i];
        for(int curr=i;curr<sum.length;curr++){
            sum[curr]+=(val-prev);
        }
    }

    public int sumRange(int i, int j) {
        return i>0?sum[j]-sum[i-1]:sum[j];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5};
        Question307 question307=new Question307(nums);
        System.out.println(question307.sumRange(0,2));;
        question307.update(1,2);
        System.out.println(question307.sumRange(0,2));;
    }
}
