package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/7/6
 */
public class Question330 {
    public int minPatches(int[] nums, int n) {
        int res=0;
        int curr=0;
        long miss=1;
        while (miss<=n){
            //miss已经覆盖到nums[curr]的位置
            if(curr<nums.length&&nums[curr]<=miss){
                miss+=nums[curr++];
            }else{
                //miss加倍，扔到miss中去，即此时需要添加miss
                miss+=miss;
                res++;
            }
        }
        return res;
    }
}
