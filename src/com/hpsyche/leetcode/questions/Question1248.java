package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odds=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                odds.add(i);
            }
        }
        if(odds.size()<k){
            return 0;
        }
        int count=0;
        for(int i=0;i<=(odds.size()-k);i++){
            int m;
            if(i==0){
                if(odds.get(i)==0){
                    m=1;
                }else{
                    m=odds.get(i)+1;
                }
            }else{
                m=odds.get(i)-odds.get(i-1);
            }
            int n;
            if(i==(odds.size()-k)){
                if(odds.get(i)==nums.length-1){
                    n=1;
                }else{
                    n=nums.length-odds.get(odds.size()-1);
                }
            }else{
                n=odds.get(i+k)-odds.get(i+k-1);
            }
            count+=(m*n);
        }
        return count;
    }

    @Test
    public void test1(){
        int i = numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
//        int i = numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
//        int i = numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
//        int i = numberOfSubarrays(new int[]{1,0,0,1,0,1,0,0,0,0,1,1,1}, 4);
        System.out.println(i);
    }
}
