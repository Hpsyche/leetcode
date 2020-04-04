package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/4
 */
public class Question650 {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        List<Integer> nums=new ArrayList<>();
        for(int i=2;i<n;i++){
            while (n%i==0){
                nums.add(i);
                n/=i;
            }
        }
        if(n>1){
            nums.add(n);
        }
        int count = nums.get(nums.size()-1);
        for(int i=0;i<nums.size()-1;i++){
            count+=nums.get(i);
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(minSteps(2));
    }
}
