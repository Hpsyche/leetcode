package com.hpsyche.leetcode.questions.question1601_1700;

/**
 * @author hpsyche
 * Create on 2020/4/28
 */
public class Question1608 {
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum^=num;
        }
        //最低为1的位置
        int index=0;
        while ((sum&1)==0){
            index++;
            sum>>=1;
        }
        int[] res=new int[2];
        for(int num:nums){
            if(((num>>index)&1)==0){
                res[0]^=num;
            }else{
                res[1]^=num;
            }
        }
        return res;
    }
}
