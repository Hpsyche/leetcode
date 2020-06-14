package com.hpsyche.leetcode.questions.question201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/14
 */
public class Question282 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, target, result, "", 0, 0, 0);
        return result;
    }

    private void dfs(String num, int target, List<String> result, String currPath, int start, long eval, long pre) {
        if(start==num.length()){
            if(target==eval){
                result.add(currPath);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            //数字不能以0开头，第一次可以（如 2+0+3中的0)
            if(num.charAt(start)=='0'&&i>start){
                break;
            }
            long curr=Long.parseLong(num.substring(start,i+1));
            //首次
            if(start==0){
                dfs(num,target,result,currPath+curr,i+1,curr,curr);
            }else{
                dfs(num,target,result,currPath+"+"+curr,i+1,eval+curr,curr);
                dfs(num,target,result,currPath+"-"+curr,i+1,eval-curr,-curr);
                //乘法 eval-pre+pre*curr
                dfs(num,target,result,currPath+"*"+curr,i+1,eval-pre+pre*curr,pre*curr);
            }
        }
    }
}
