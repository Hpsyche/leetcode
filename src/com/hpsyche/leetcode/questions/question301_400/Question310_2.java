package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/6/23
 */
public class Question310_2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
//      1.条件判断（边界判断，其他要求的判断）
        if (n == 1){
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];//每个节点的度数
        List<List<Integer>> map = new ArrayList<>();//每个节点
        for (int i=0;i<n;i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge:edges){
            degree[edge[0]]++;//计算edge[0]节点的度数
            degree[edge[1]]++;//计算edge[1]节点的度数
            map.get(edge[0]).add(edge[1]);//跟edge[0]相邻的节点
            map.get(edge[1]).add(edge[0]);//跟edge[1]相邻的节点
        }
//      2.创建队列
        Queue<Integer> queue = new LinkedList<>();

//      3.在队列中加入第一个满足条件的元素
        for (int i = 0;i < n;i++){
            if (degree[i] == 1){//度数为1，说明是叶子结点,入队列
                queue.offer(i);
            }
        }
//      4.while(队列不为空) {
//            取出队列头部元素
//            操作
//            根据头部元素，往队列中再次加入满足条件的元素
//        }
        while (!queue.isEmpty()){
            ans=new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                int cur = queue.poll();
                ans.add(cur);
                List<Integer> nexts = map.get(cur);
                for (Integer next:nexts){
                    degree[next]--;//删除叶子节点后，跟其相邻的节点的度数要减少
                    if (degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }

        return  ans;
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
