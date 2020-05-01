package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/5/1
 */
public class Question96 {
    Map<String,Long> map=new HashMap<>();
    public int numTrees(int n) {
        if(n==0){
            return 0;
        }
        return (int)helper(1,n);
    }

    private long helper(int start, int end) {
        if(start>end){
            return 1;
        }
        if(start==end){
            return 1;
        }
        if(map.containsKey(start+":"+end)){
            return map.get(start+":"+end);
        }
        long res=0;
        for (int i = start; i <= end; i++) {
            long left = helper(start, i - 1);
            long right = helper(i + 1, end);
            res+=left*right;
        }
        map.put(start+":"+end,res);
        return res;
    }


    public int numTrees2(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for(int j=0;j<i;j++){
                dp[i]+=dp[i-j-1]*dp[j];
            }
        }
        return dp[n];
    }

    @Test
    public void test1(){
        int list = numTrees(100);
        System.out.println(list);
    }
}
