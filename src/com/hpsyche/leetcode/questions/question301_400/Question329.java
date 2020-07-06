package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/7/5
 */
public class Question329 {
    private int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] cache=new int[m][n];
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max=Math.max(max,dfs(matrix,i,j,cache));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j,int[][] cache) {
        if(cache[i][j]!=0){
            return cache[i][j];
        }
        int count=0;
        for(int[] d:dirs){
            int currX=i+d[0];
            int currY=j+d[1];
            if(currX>=0&&currX<matrix.length&&currY>=0&&currY<matrix[0].length&&matrix[currX][currY]>matrix[i][j]){
                count=Math.max(count,dfs(matrix,currX,currY,cache));
            }
        }
        count++;
        cache[i][j]=count;
        return count;
    }


    @Test
    public void test1(){
        int[][] matrix=new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
}
