package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/13
 */
public class Question275 {
    public int hIndex(int[] citations) {
        int len=citations.length;
        int left=0;
        int right=len-1;
        int res=0;
        while (left<=right){
            int mid=left+((right-left)>>1);
            int h=len-mid;
            if(h<=citations[mid]){
                res=h;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] temp=new int[]{0,1,3,3,5,6};
//        int[] temp=new int[]{1  };
        System.out.println(hIndex(temp));

    }
}
