package com.hpsyche.leetcode.questions.question301_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/6/18
 */
public class Question301 {
    int max=0;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set=new HashSet<>();
        set.add("");
        //从第一个字符开始，通过深度优先遍历的顺序，遍历到最后一个字符后判断当前路径上的字符串是否合法。
        dfs(s,0,s.length(),0,"",set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int start, int end, int count, String temp, Set<String> set) {
        if(count<0){
            return;
        }
        if(start==end){
            if(count==0){
                if(temp.length()>max){
                    set.clear();
                    set.add(temp);
                    max=temp.length();
                }else if(temp.length()==max){
                    set.add(temp);
                    max=temp.length();
                }
            }
            return;
        }
        if(s.charAt(start)=='('){
            dfs(s,start+1,end,count+1,temp+"(",set);
        }else if(s.charAt(start)==')'){
            dfs(s,start+1,end,count-1,temp+")",set);
        }else{
            dfs(s,start+1,end,count,temp+s.charAt(start),set);
        }
        if(s.charAt(start)=='('||s.charAt(start)==')'){
            dfs(s,start+1,end,count,temp,set);
        }
    }
}
