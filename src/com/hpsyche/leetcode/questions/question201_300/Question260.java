package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/11
 */
public class Question260 {
    public int[] singleNumber(int[] nums) {
        int temp=0;
        for(int num:nums){
            temp^=num;
        }
        int diff=1;
        while ((temp&1)==0){
            temp>>=1;
            diff<<=1;
        }
        int[] res=new int[2];
        for(int num:nums){
            if((num&diff)==0){
                res[0]^=num;
            }else{
                res[1]^=num;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] ints=new int[]{1,0};
        int[] ints1 = singleNumber(ints);
        for(int i:ints1){
            System.out.println(i);
        }
    }
}
