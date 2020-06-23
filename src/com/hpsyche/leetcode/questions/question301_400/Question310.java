package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/6/21
 */
public class Question310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] count=new int[n];
        for(int i=0;i<n;i++){
             map.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            count[edge[0]]++;
            count[edge[1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(count[i]==1){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            res=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int curr=queue.poll();
                res.add(curr);
                List<Integer> list = map.get(curr);
                if(list.size()==0){
                    break;
                }
                int next = list.get(0);
                map.get(next).remove(new Integer(curr));
                count[next]--;
                if(count[next]==1){
                    queue.add(next);
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
//        int[][] ed=new int[][]{
//                {1,0},{1,2},{1,3}
//        };
        int[][] ed=new int[][]{
                {0,1},{0,2},{2,3},{0,4},{2,5},{5,6},{3,7},{6,8},{8,9},{9,10}
        };
        List<Integer> minHeightTrees = findMinHeightTrees(11, ed);
        for(int i:minHeightTrees){
            System.out.println(i);
        }
    }
}
