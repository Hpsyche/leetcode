package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/21
 */
public class Question48 {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //对称矩阵
        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<=(n-1)/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    @Test
    public void test1(){
//        rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
}
