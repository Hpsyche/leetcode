package com.hpsyche.leetcode.questions.question1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/9
 */
public class Question39 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int i, ArrayList<Integer> tempList) {
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int start=i;start<candidates.length;start++){
            if(target-candidates[start]<0){
                break;
            }
            tempList.add(candidates[start]);
            dfs(candidates,target-candidates[start],start,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
