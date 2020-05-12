package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/12
 */
public class Question188 {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        if(len<=1){
            return 0;
        }
        if(k>prices.length/2){ return profit(prices);}
        int[][][] dp=new int[len][k+1][2];
        for(int i=0;i<len;i++){
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
            for(int j=k;j>=1;j--){
                if(i==0){
                    dp[0][j][0]=0;
                    dp[0][j][1]=-prices[i];
                    continue;
                }
                //k：持有股票数量
                //买才考虑k
                //只负责把本次买入的卖出去。所以不用考虑上一次的交易情况。
                //解释：今天我没有持有股票，有两种可能：
                //要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
                //要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                //解释：今天我持有着股票，有两种可能：
                //要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
                //要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[len-1][k][0];
    }

    private int profit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int tmp = 0;
        for (int price : prices) {
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, tmp - price);
        }
        return dp_i_0;
    }
}
