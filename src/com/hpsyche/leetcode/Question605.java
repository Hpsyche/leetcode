package com.hpsyche.leetcode;

/**
 * @author hpsyche
 * Create on 2020/3/10
 */
public class Question605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int currNum=0;
        int count=1;
        for (int value : flowerbed) {
            if (value == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                currNum++;
                count = 1;
            }
        }
        if(count==2){
            currNum++;
        }
        return n<=currNum;
    }
}
