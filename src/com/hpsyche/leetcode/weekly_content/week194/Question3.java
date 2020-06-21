package com.hpsyche.leetcode.weekly_content.week194;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/6/21
 * 当会泛滥时，找个位置抽干，若找不到的合适位置的话，返回空数组。
 * 选取的位置在上次蓄水的索引往后，当前索引之前，建个map存一下就好了。
 */
public class Question3 {
    public int[] avoidFlood(int[] rains) {
        if(rains==null||rains.length==0){
            return new int[0];
        }
        int[] ans=new int[rains.length];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < ans.length; i++) {
            if(rains[i]>0){
                ans[i]=-1;
                if(map.containsKey(rains[i])){
                    int index=map.get(rains[i])+1;
                    while (ans[index]!=0&&index<i){
                        index++;
                    }
                    if(index==i){
                        return new int[0];
                    }
                    ans[index]=rains[i];
                }
            }
            map.put(rains[i],i);
        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==0){
                ans[i]=1;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] temp=new int[]{1,2,0,0,2,1};
        System.out.println(avoidFlood(temp));
    }
}
