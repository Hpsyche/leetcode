package com.hpsyche.leetcode.questions.question1_100;

/**
 * @author hpsyche
 * Create on 2020/4/24
 */
public class Question73 {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        boolean row0=false;
        boolean col0=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    if(i==0){
                        row0=true;
                    }
                    if(j==0){
                        col0=true;
                    }
                    matrix[0][j]=matrix[i][0]=0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {matrix[i][0] = 0;}
        }
        if (row0) {
            for (int j = 0; j < n; j++) {matrix[0][j] = 0;}
        }
    }
}
