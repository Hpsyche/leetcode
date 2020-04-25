package com.hpsyche.leetcode.questions.question1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/25
 */
public class Question78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }
}
