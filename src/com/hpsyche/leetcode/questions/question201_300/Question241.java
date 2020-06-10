package com.hpsyche.leetcode.questions.question201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/6/10
 */
public class Question241 {
    Map<String,List<Integer>> map=new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<>();
        if(input.length()==0){
            return res;
        }
        if(map.containsKey(input)){
            return map.get(input);
        }
        int curr=0;
        int num=0;
        while (curr<input.length()&&!isOperation(input.charAt(curr))){
            num=num*10+input.charAt(curr)-'0';
            curr++;
        }
        if(curr==input.length()){
            res.add(num);
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if(isOperation(input.charAt(i))){
                List<Integer> result1=diffWaysToCompute(input.substring(0,i));
                List<Integer> result2=diffWaysToCompute(input.substring(i+1));
                for (Integer integer : result1) {
                    for (Integer value : result2) {
                        char op = input.charAt(i);
                        res.add(calculate(integer, op, value));
                    }
                }
            }
        }
        map.put(input,res);
        return res;    
    }

    private int calculate(int numA, char c, int numB) {
        switch (c){
            case '+':
                return numA+numB;
            case '-':
                return numA-numB;
            case '*':
                return numA*numB;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c=='+'||c=='-'||c=='*';
    }

}
