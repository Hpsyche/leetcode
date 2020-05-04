package com.hpsyche.leetcode.questions.question901_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/4
 */
public class Question994_2 {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    count++;
                }else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int round=0;
        while (count>0&&!queue.isEmpty()){
            round++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] poll = queue.poll();
                int x=poll[0];
                int y=poll[1];
                if(x-1>=0&&grid[x-1][y]==1){
                    grid[x-1][y]=2;
                    count--;
                    queue.add(new int[]{x-1,y});
                }
                if(x+1<m&&grid[x+1][y]==1){
                    grid[x+1][y]=2;
                    count--;
                    queue.add(new int[]{x+1,y});
                }
                if(y-1>=0&&grid[x][y-1]==1){
                    grid[x][y-1]=2;
                    count--;
                    queue.add(new int[]{x,y-1});
                }
                if(y+1<n&&grid[x][y+1]==1){
                    grid[x][y+1]=2;
                    count--;
                    queue.add(new int[]{x,y+1});
                }
            }
        }
        return count>0?-1:round;
    }
}
