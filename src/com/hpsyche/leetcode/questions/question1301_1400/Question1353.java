package com.hpsyche.leetcode.questions.question1301_1400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/3/21
 */
public class Question1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (arr1, arr2) -> arr1[1]==arr2[1]?arr1[0]-arr2[1]:arr1[1]-arr2[1]);
        Set<Integer> set=new HashSet<>();
        for(int[] event:events){
            for(int i=event[0];i<=event[1];i++){
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }
}
