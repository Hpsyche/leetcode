package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/7/8
 */
public class Question335 {
    public boolean isSelfCrossing(int[] x) {
        int len=x.length;
        for (int i = 0; i < len; i++) {
            if(i>=3&&x[i-1]<=x[i-3]&&x[i]>=x[i-2]){
                return true;
            }
            if(i>=4&&x[i-3]==x[i-1]&&x[i]+x[i-4]>=x[i-2]){
                return true;
            }
            if(i>=5 && x[i]+x[i-4]>=x[i-2] && x[i-1]+x[i-5]>=x[i-3]
                    && x[i-2]>x[i-4] && x[i-3]>x[i-1]){
                return true;
            }
        }
        return false;
    }
}