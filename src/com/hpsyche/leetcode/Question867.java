package com.hpsyche.leetcode;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/6
 */
public class Question867 {
    public int[][] transpose(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        int[][] res=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i]=A[i][j];
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[][] temp=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        int[][] transpose = transpose(temp);
        for(int[] arr:transpose){
            for(int i:arr){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
