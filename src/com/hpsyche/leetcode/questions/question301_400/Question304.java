package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/19
 */
public class Question304 {
    private int[][] sum;
    public Question304(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        this.sum=new int[m][n];
        int curr=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curr+=matrix[i][j];
                if(i==0){
                    sum[i][j]=curr;
                }else{
                    sum[i][j]=sum[i-1][j]+curr;
                }
            }
            curr=0;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left=col1>0?sum[row2][col1-1]:0;
        int top=row1>0?sum[row1-1][col2]:0;
        int repeat=col1>0&&row1>0?sum[row1-1][col1-1]:0;
        return sum[row2][col2]-left-top+repeat;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        };
        Question304 question304=new Question304(matrix);
        for(int[] temp:question304.sum){
            for(int i:temp){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
