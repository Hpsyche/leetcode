package com.hpsyche.leetcode.questions.question401_500;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/8
 */
public class Question463 {
    public int islandPerimeter(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int num=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1) {
                    num += 4;
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        num -= 2;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        num -= 2;
                    }
                }
            }
        }
        return num;
    }

    @Test
    public void test1(){
//        int[][] grid=new int[][]{
//                {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}
//        };
        int[][] grid=new int[][]{
                {0,0,1,1},{0,0,1,1}
        };
        System.out.println(islandPerimeter(grid));
    }


}
