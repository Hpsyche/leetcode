package com.hpsyche.leetcode.shopee;

import java.util.Scanner;

/**
 * @author hpsyche
 * Create on 2020/2/15
 */
public class Question3_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         int m = scanner.nextInt();
        int n = scanner.nextInt();
        long[][] dp=new long[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-2;i>=0;i--){
            dp[i][n-1]=1;
        }
        for(int i=n-2;i>=0;i--){
            dp[m-1][i]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        System.out.println(dp[0][0]);
    }
}
