package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/28
 */
public class Question319 {
//    public int bulbSwitch(int n) {
//        boolean[] flags=new boolean[n];
//        for (int i = 1; i <= n; i++) {
//            int curr=i-1;
//            while (curr<n){
//                flags[curr]=!flags[curr];
//                curr+=i;
//            }
//        }
//        int count=0;
//        for (int i = 0; i < n; i++) {
//            if(flags[i]){
//                count++;
//            }
//        }
//        return count;
//    }

    /**
     * 第i个灯泡的反转次数等于它所有因子（包括1和i）的个数，一开始的状态的灭的，只有反转奇数次才会变成亮的，
     * 所以只有因子个数为奇数的灯泡序号才会亮，只有平方数的因子数为奇数（比如6=1*6,2*3，它们的因子总是成对出现的，
     * 而4=1*4,2*2，只有平方数的平方根因子会只出现1次），所以最终答案等于n以内（包括n和1）的平方数数量，只要计算sqrt(n)即可
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

    @Test
    public void test1() {
        System.out.println(bulbSwitch(0));
    }
}
