package com.hpsyche.leetcode.questions.question1401_1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/7
 */
public class Question1419 {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows=new ArrayList<>();
        List<Integer> cols=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int row:rows){
            for(int i=0;i<n;i++){
                matrix[row][i]=0;
            }
        }
        for(int col:cols){
            for(int i=0;i<m;i++){
                matrix[i][col]=0;
            }
        }
    }
}
