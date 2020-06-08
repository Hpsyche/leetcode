package com.hpsyche.leetcode.questions.question901_1000;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/8
 */
public class Question990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf=new UnionFind(26);
        for(String equation:equations){
            if(equation.charAt(1)=='='){
                uf.union(equation.charAt(0)-'a',equation.charAt(3)-'a');
            }
        }
        for(String equation:equations) {
            if(equation.charAt(1)=='!'&&uf.findRoot(equation.charAt(0)-'a')==uf.findRoot(equation.charAt(3)-'a')){
                return false;
            }
        }
        return true;
    }

    class UnionFind{
        private int[] nums;
        private int[] ranks;
        UnionFind(int num){
            nums=new int[num];
            ranks=new int[num];
            for (int i = 0; i < num; i++) {
                nums[i]=-1;
                ranks[i]=0;
            }
        }
        int findRoot(int curr){
            while (nums[curr]!=-1){
                curr=nums[curr];
            }
            return curr;
        }
        void union(int x,int y){
            int xRoot=findRoot(x);
            int yRoot=findRoot(y);
            if(xRoot==yRoot){
                return;
            }
            int xRank=ranks[xRoot];
            int yRank=ranks[yRoot];
            if(xRank<yRank){
                nums[xRoot]=yRoot;
            }else if(xRank>yRank){
                nums[yRoot]=xRoot;
            }else{
                nums[yRoot]=xRoot;
                ranks[xRoot]++;
            }
        }
    }

    @Test
    public void test1(){
        String[] strs=new String[]{"c==c","b==d","c==d","c!=b"};
        boolean b = equationsPossible(strs);
        System.out.println(b);
    }
}
