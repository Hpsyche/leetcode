package com.hpsyche.leetcode;

import org.junit.Test;


/**
 * 背包问题
 * @author hpsyche
 * Create on 2020/3/27
 */
public class Question1049 {
    /**
     * 二维数组
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        int target=sum>>1;
        int[][] dp=new int[stones.length+1][target+1];
        for(int i=1;i<=stones.length;i++){
            for(int j=1;j<=target;j++){
                if(j<stones[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    int value1=dp[i-1][j];
                    int value2=dp[i-1][j-stones[i-1]]+stones[i-1];
                    dp[i][j]=Math.max(value1,value2);
                }
            }
        }
        return sum-2*dp[stones.length][target];
    }

    /**
     * 一维数组
     * @param stones
     * @return
     */
    public int lastStoneWeightII2(int[] stones) {
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        int target=(sum>>1)+1;
        int[] dp=new int[target];
        for(int i=0;i<stones.length;i++){
            for(int j=target-1;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],stones[i]+dp[j-stones[i]]);
            }
        }
        return sum-2*dp[target-1];
    }


        @Test
    public void test1(){
        System.out.println(lastStoneWeightII2(new int[]{2,7,4,1,8,1}));;
    }
}
