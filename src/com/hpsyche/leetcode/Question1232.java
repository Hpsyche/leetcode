package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2020/3/11
 */
public class Question1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        double x=coordinates[0][0]-coordinates[1][0];
        double y=coordinates[0][1]-coordinates[1][1];
        if(y==0){
            for(int i=1;i<coordinates.length-1;i++){
                if((coordinates[i][1] - coordinates[i + 1][1])!=0){
                    return false;
                }
            }
        }else {
            double k = x / y;
            for (int i = 1; i < coordinates.length - 1; i++) {
                double tempX = coordinates[i][0] - coordinates[i + 1][0];
                double tempY = coordinates[i][1] - coordinates[i + 1][1];
                if (tempX / tempY != k) {
                    return false;
                }
            }
        }
        return true;
    }
}
