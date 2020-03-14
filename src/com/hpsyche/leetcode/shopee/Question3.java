package com.hpsyche.leetcode.shopee;

import java.util.Scanner;

/**
 * @author hpsyche
 * Create on 2020/2/15
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[][] dp=new String[m][n];
        dp[m-1][n-1]="1";
        for(int i=m-2;i>=0;i--){
            dp[i][n-1]="1";
        }
        for(int i=n-2;i>=0;i--){
            dp[m-1][i]="1";
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
//                dp[i][j]=dp[i+1][j]+dp[i][j+1];
                dp[i][j]=bigNumAdd(dp[i+1][j],dp[i][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }

    public static String bigNumAdd(String str1,String str2){
        StringBuilder sb=new StringBuilder("");
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();
        int currPosition1=char1.length-1;
        int currPosition2=char2.length-1;
        //进位判断
        boolean forward=false;
        while (currPosition1>=0&&currPosition2>=0){
            char curr1=char1[currPosition1];
            char curr2=char2[currPosition2];
            int sum=curr1-'0'+curr2-'0';
            if(forward){
                sum+=1;
            }
            forward= sum >= 10;
            sb.append((char)((sum%10)+'0'));
            currPosition1--;
            currPosition2--;
        }
        //当两个字符串长度不相等时，剩下的位置
            while(currPosition1>=0){
                int sum=char1[currPosition1]-'0'+(forward?1:0);
                forward=sum>=10;
                sb.append((char)((sum%10)+'0'));
                currPosition1--;
            }
        while(currPosition2>=0){
            int sum=char2[currPosition2]-'0'+(forward?1:0);
            forward=sum>=10;
            sb.append((char)((sum%10)+'0'));
            currPosition2--;
        }
        //如果还有进位
        if(forward){
            sb.append("1");
        }
        return sb.reverse().toString();
     }
}
