package com.hpsyche.leetcode.questions;

/**
 * @author hpsyche
 * Create on 2020/4/7
 */
public class Question1418 {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int mid=m>>1;
        for(int i=0;i<m;i++){
            for(int j=0;j<mid;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m-1-j];
                matrix[i][m-1-j]=temp;
            }
        }
    }
}
