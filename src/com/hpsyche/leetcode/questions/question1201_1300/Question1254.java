package com.hpsyche.leetcode.questions.question1201_1300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/8
 */
public class Question1254 {
    public int closedIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        count++;
                    };
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return false;
        }
        if(grid[i][j]==1){
            return true;
        }
        grid[i][j]=1;
        int[] x=new int[]{0,1,0,-1};
        int[] y=new int[]{1,0,-1,0};
        boolean flag=true;
        for(int k=0;k<x.length;k++){
            flag=dfs(grid,i+x[k],j+y[k])&flag;
        }
        return flag;
    }

    @Test
    public void test1(){
        int[][] grid=new int[][]{
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        System.out.println(closedIsland(grid));
    }
}
