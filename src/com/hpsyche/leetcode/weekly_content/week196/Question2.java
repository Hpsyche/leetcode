package com.hpsyche.leetcode.weekly_content.week196;

/**
 * @author hpsyche
 * Create on 2020/7/5
 */
public class Question2 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res=0;
        for(int l:left){
            res=Math.max(res,l);
        }
        for(int r:right){
            res=Math.max(res,n-r);
        }
        return res;
    }
}
