package com.hpsyche.leetcode.weekly_content.week195;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/6/28
 */
public class Question1 {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer,Integer>> set=new HashSet<>();
        int x=0;
        int y=0;
        set.add(new Pair<>(0,0));
        for(char c:path.toCharArray()){
            if(c=='N'){
                x++;
            }else if(c=='S'){
                x--;
            }else if(c=='E'){
                y++;
            }else if(c=='W'){
                y--;
            }
            if(set.contains(new Pair<>(x,y))){
                return true;
            }
            set.add(new Pair<>(x,y));
        }
        return false;
    }


    @Test
    public void test1(){
        //
        boolean nnswwewssesswennw = isPathCrossing("NNSWWEWSSESSWENNW");
        System.out.println(nnswwewssesswennw);
    }
}
