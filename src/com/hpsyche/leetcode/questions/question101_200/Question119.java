package com.hpsyche.leetcode.questions.question101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question119 {
    public List<Integer> getRow(int rowIndex) {
        int[] dp=new int[rowIndex];
        Arrays.fill(dp,1);
        for(int i=2;i<rowIndex;i++){
            for(int j=i-1;j>0;j--){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        List<Integer> res=new ArrayList<>(rowIndex);
        for(int i:dp){
            res.add(i);
        }
        return res;
    }
}
