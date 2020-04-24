package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/20
 */
public class Question200 {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        helper(grid,i,j+1);
        helper(grid,i,j-1);
        helper(grid,i+1,j);
        helper(grid,i-1,j);
    }


    @Test
    public void test1() {
//        char[][] temp = new char[][]{{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
//        char[][] temp = new char[][]{{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] temp = new char[][]{{'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };

        int i = numIslands(temp);
        System.out.println(i);
    }
}
