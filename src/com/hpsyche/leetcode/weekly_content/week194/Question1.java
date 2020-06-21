package com.hpsyche.leetcode.weekly_content.week194;

/**
 * @author hpsyche
 * Create on 2020/6/21
 */
public class Question1 {
    public int xorOperation(int n, int start) {
        int index=0;
        int res=0;
        while (index<n){
            int curr=start+2*index;
            res^=curr;
            index++;
        }
        return res;
    }
}
