package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/3/27
 */
public class Question54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new ArrayList<>();
        }
        int bX=0;
        int bY=0;
        int eX=matrix.length-1;
        int eY=matrix[0].length-1;
        List<Integer> res=new ArrayList<>((eX+1)*(eY+1));
        while (bX<=eX&&bY<=eY){
            printOrder(res,matrix,bX++,bY++,eX--,eY--);
        };
        return res;
    }

    private void printOrder(List<Integer> res, int[][] matrix, int bX, int bY, int eX, int eY) {
        if(bX==eX){
            for(int i=bY;i<=eY;i++){
                res.add(matrix[bX][i]);
            }
            return;
        }
        if(bY==eY){
            for(int i=bX;i<=eX;i++){
                res.add(matrix[i][bY]);
            }
            return;
        }
        for(int i=bY;i<eY;i++){
            res.add(matrix[bX][i]);
        }
        for(int i=bX;i<eX;i++){
            res.add(matrix[i][eY]);
        }
        for(int i=eY;i>bY;i--){
            res.add(matrix[eX][i]);
        }
        for(int i=eX;i>bX;i--){
            res.add(matrix[i][bY]);
        }
    }

    @Test
    public void test1(){
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3}, { 4,5, 6}, {7,8, 9}});
        for(int i:list){
            System.out.println(i);
        }
    }
}
