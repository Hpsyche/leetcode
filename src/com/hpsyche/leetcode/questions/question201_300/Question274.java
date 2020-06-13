package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hpsyche
 * Create on 2020/6/13
 */
public class Question274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        for (int i = 0; i < len; i++) {
            int h=len-i;
            if(h<=citations[i]){
                return h;
            }
        }
        return 0;
    }

    @Test
    public void test1(){
        int[] temp=new int[]{3,0,6,1,5,3};
//        int[] temp=new int[]{1  };
        System.out.println(hIndex(temp));
    }
}
