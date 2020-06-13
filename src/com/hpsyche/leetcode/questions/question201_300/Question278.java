package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/13
 */
public class Question278 {
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while (left<right){
            int mid=left+((right-left)>>1);
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }

    private boolean isBadVersion(int n) {
        if(n>=3){
            return true;
        }
        return false;
    }

    @Test
    public void test1(){
        int i = firstBadVersion(10);
        System.out.println(i);
    }
}
