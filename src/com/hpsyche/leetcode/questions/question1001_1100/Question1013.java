package com.hpsyche.leetcode.questions.question1001_1100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/5
 */
public class Question1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int a:A){
            sum+=a;
        }
        if(sum%3!=0){
            return false;
        }
        sum/=3;
        int count=0;
        int currSum=0;
        for(int a:A){
            currSum+=a;
            if(currSum==sum){
                count++;
                if(count==3){
                    return true;
                }
                currSum=0;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        System.out.println(canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
//        System.out.println(canThreePartsEqualSum(new int[]{0,0,0,0}));
    }
}
