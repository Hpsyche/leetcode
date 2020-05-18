package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/18
 */
public class Question137 {
    public int singleNumber(int[] nums) {
        int[] counts=new int[32];
        for(int num:nums){
            for(int j=0;j<32;j++){
                counts[j]+=num&1;
                num>>>=1;
            }
        }
        int res=0;
        int m=3;
        for(int i=0;i<32;i++){
            res<<=1;
            int curr=counts[31-i]%m;
            res|=curr;
        }
        return res;
    }
}
