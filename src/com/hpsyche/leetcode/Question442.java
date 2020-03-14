package com.hpsyche.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/1/25
 */
public class Question442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList=new ArrayList<>();
        for(int i:nums){
            if(nums[Math.abs(i)-1]<0){
                resList.add(Math.abs(i));
            }else{
                nums[Math.abs(i)-1]*=-1;
            }
        }
        return resList;
    }
}
