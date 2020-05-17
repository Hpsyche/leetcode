package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/17
 */
public class Question135 {
    public int candy(int[] ratings) {
        int len=ratings.length;
        int[] left=new int[len];
        int[] right=new int[len];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for (int i = len-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
        }
        int count=0;
        for (int i = 0; i < len; i++) {
            count+= Math.max(left[i],right[i]);
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(candy(new int[]{1,2,2}));
    }
}
