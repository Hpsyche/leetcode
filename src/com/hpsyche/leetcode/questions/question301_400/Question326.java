package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/6/30
 */
public class Question326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
