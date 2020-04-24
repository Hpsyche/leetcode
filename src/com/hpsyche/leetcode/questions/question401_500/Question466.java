package com.hpsyche.leetcode.questions.question401_500;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/19
 */
public class Question466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int num1=0;
        int num2=0;
        int s2Curr=0;
        while (num1<n1){
            for (char c : chars1) {
                if (c == chars2[s2Curr]) {
                    s2Curr++;
                    if (s2Curr == chars2.length) {
                        s2Curr = 0;
                        num2++;
                    }
                }
            }
            num1++;
            //如果s2的指针指到了开头，说明正好找到了循环的点
            if(s2Curr==0){
                int temp = (int)(n1 / num1);
                num1*=(int)(temp);
                num2*=(int)(temp);
            }
        }
        return num2/n2;
    }

    @Test
    public void test1(){
        int maxRepetitions = getMaxRepetitions("acb", 4, "ab", 2);
        System.out.println(maxRepetitions);
    }
}
