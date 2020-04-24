package com.hpsyche.leetcode.questions.question1501_1600;

/**
 * @author hpsyche
 * Create on 2020/4/8
 */
public class Question1531 {
    public int movingCount(int m, int n, int k) {
        boolean[][] flag=new boolean[m][n];
        return helper(0,0,m,n,flag,k);
    }

    private int helper(int i, int j, int m, int n, boolean[][] flag,int k) {
        if(i<0||i>=m||j<0||j>=n||numSum(i)+numSum(j)>k||flag[i][j]){
            return 0;
        }
        flag[i][j]=true;
        return helper(i-1,j,m,n,flag,k)+helper(i+1,j,m,n,flag,k)
                +helper(i,j+1,m,n,flag,k)+helper(i,j-1,m,n,flag,k)
                +1;
    }

    private int numSum(int i) {
        int sum=0;
        do{
            sum+=i%10;
        }while ((i=i/10)>0);
        return sum;
    }
}
