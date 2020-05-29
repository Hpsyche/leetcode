package com.hpsyche.leetcode.questions.question101_200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hpsyche
 * Create on 2020/5/29
 */
public class Question179 {
    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i]=nums[i]+"";
        }
        Arrays.sort(strs, (str1, str2) -> (str2+str1).compareTo(str1+str2));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumberStr = new StringBuilder("");
        for (String numAsStr : strs) {
            largestNumberStr.append(numAsStr);
        }
        return largestNumberStr.toString();
    }
}
