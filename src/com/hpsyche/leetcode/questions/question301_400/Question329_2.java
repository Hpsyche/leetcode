package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/7/5
 */
public class Question329_2 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] visit=new int[m][n];
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max=Math.max(max,dfs(matrix,i,j,visit));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] visit) {
        if(visit[i][j]>0){
            return visit[i][j];
        }
        int max=0;
        if(j>0&&matrix[i][j]<matrix[i][j-1]){
            max=Math.max(max,dfs(matrix,i,j-1,visit));
        }
        if(j<matrix[0].length-1&&matrix[i][j]<matrix[i][j+1]){
            max=Math.max(max,dfs(matrix,i,j+1,visit));
        }
        if(i>0&&matrix[i][j]<matrix[i-1][j]){
            max=Math.max(max,dfs(matrix,i-1,j,visit));
        }
        if(i<matrix.length-1&&matrix[i][j]<matrix[i+1][j]){
            max=Math.max(max,dfs(matrix,i+1,j,visit));
        }
        visit[i][j]=max+1;
        return max+1;
    }

    @Test
    public void test1(){
        int[][] matrix=new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
}
