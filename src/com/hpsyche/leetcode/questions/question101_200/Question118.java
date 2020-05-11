package com.hpsyche.leetcode.questions.question101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/5/11
 */
public class Question118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> prev = res.get(i - 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}
