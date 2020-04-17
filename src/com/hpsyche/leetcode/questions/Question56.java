package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/4/16
 */
public class Question56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res=new LinkedList<>();
        if(intervals==null||intervals.length==0){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        for(int i=0;i<intervals.length;i++){
            if(res.isEmpty()||res.getLast()[1]<intervals[i][0]){
                res.add(intervals[i]);
            }else{
                res.getLast()[1]=Math.max(res.getLast()[1],intervals[i][1]);
            }
        }
        return res.toArray(new int[0][]);
    }

    @Test
    public void test1(){
//        int[][] merge = merge(new int[][]{{1, 4}, {4, 5}});
//        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] merge=merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        for(int[] temp:merge){
            for(int t:temp){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
