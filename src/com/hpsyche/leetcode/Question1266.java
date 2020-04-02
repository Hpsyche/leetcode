package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2020/4/2
 */
public class Question1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count=0;
        if(points.length<2){
            return 0;
        }
        for(int i=1;i<points.length;i++){
            count+=helper(points,i,i-1);
        }
        return count;
    }

    private int helper(int[][] points, int i, int j) {
        int iX=points[i][0];
        int iY=points[i][1];
        int jX=points[j][0];
        int jY=points[j][1];
        return Math.max(Math.abs(iX-jX),Math.abs(iY-jY));
    }


}
