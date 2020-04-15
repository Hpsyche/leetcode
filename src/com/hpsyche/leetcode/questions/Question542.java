package com.hpsyche.leetcode.questions;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/4/15
 */
public class Question542 {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return null;
        }
        int[][] dire=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            int x=position[0];
            int y=position[1];
            for(int[] d:dire){
                int newX=x+d[0];
                int newY=y+d[1];
                if(newX<0||newX>=m||newY<0||newY>=n||visited[newX][newY]){
                    continue;
                }
                res[newX][newY]=res[x][y]+1;
                visited[newX][newY]=true;
                queue.add(new int[]{newX,newY});
            }
        }
        return res;
    }
}
