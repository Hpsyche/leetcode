package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/3/27
 */
public class Question914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int temp:deck){
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                map.replace(temp,map.get(temp)+1);
            }
        }
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        int x=-1;
        while (iterator.hasNext()){
            Integer curr = map.get(iterator.next());
            x=x==-1?curr:gcd(x,curr);
            if(x==1){
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        return b==0?a:gcd(b,a%b);
    }

    @Test
    public void test1(){
        System.out.println(hasGroupsSizeX(new int[]{1}));
    }
}
