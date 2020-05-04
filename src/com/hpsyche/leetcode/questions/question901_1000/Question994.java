package com.hpsyche.leetcode.questions.question901_1000;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question994 {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
            }
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }else{
                    max=Math.max(max,grid[i][j]);
                }
            }
        }
        return max==0?0:max-2;
    }

    /**
     * 传播路径长度就是传染的天数。。我们从多个烂橘子开始dfs，对于某一个新橘子，它可能在多个烂橘子的传染路径上，得以最快可以传染
     * 这个新橘子的那个路径为准。因此每个橘子腐烂时需要把它腐烂的路径长度（天数）记录下来，如果发现另一条路径会更早感染这个橘子的话
     * 就更新路径长度（天数）。😥然后...嗯为了偷懒存储每个橘子的路径长度时没有额外定义一个二维数组，直接覆盖的gird原数组，
     * 而grid数组已经有2了，所以我的长度被迫从2开始，，😳最后要减2
     * @param grid
     * @param i
     * @param j
     * @param level
     */
    private void dfs(int[][] grid, int i, int j,int level) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if(grid[i][j]!=1&&grid[i][j]<level){
            return;
        }
        grid[i][j]=level;
        level++;
        dfs(grid,i+1,j,level);
        dfs(grid,i-1,j,level);
        dfs(grid,i,j+1,level);
        dfs(grid,i,j-1,level);
    }
}
