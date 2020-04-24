package com.hpsyche.leetcode.questions.question1_100;

import java.util.LinkedList;

/**
 * @author hpsyche
 * Create on 2020/4/22
 */
public class Question57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart=newInterval[0];
        int newEnd=newInterval[1];
        int index=0;
        int n=intervals.length;
        LinkedList<int[]> out=new LinkedList<>();
        //将 newInterval 之前开始的区间添加到输出。
        while (index<n&&newStart>intervals[index][0]){
            out.add(intervals[index++]);
        }
        int[] interval=new int[2];
        //添加 newInterval 到输出，若 newInterval 与输出中的最后一个区间重合则合并他们。
        if(out.isEmpty()|| out.getLast()[1] < newStart){
            out.add(newInterval);
        }else{
            interval = out.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            out.add(interval);
        }
        //一个个添加区间到输出，若有重叠部分则合并他们。
        while (index<n){
            interval=intervals[index++];
            int start = interval[0], end = interval[1];
            if (out.getLast()[1] < start) {
                out.add(interval);
            }
            else {
                interval = out.removeLast();
                interval[1] = Math.max(interval[1], end);
                out.add(interval);
            }
        }
        return out.toArray(new int[out.size()][2]);
    }
}
