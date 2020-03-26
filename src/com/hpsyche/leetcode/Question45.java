package com.hpsyche.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hpsyche
 * Create on 2020/3/26
 */
public class Question45 {
    public String minNumber(int[] nums) {
        String[] temp=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(temp, (s1, s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb=new StringBuilder("");
        for(String str:temp){
            sb.append(str);
        }
        return sb.toString();
    }
}
