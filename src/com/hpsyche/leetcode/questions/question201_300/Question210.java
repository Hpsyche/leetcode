package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/5/17
 */
public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> []lists=new ArrayList[numCourses];
        int[] entry=new int[numCourses];
        for(int[] p:prerequisites){
            entry[p[0]]++;
            if(lists[p[1]]==null){
                lists[p[1]]=new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(entry[i]==0){
                queue.add(i);
            }
        }
        List<Integer> res=new LinkedList<>();
        while (!queue.isEmpty()){
            int poll = queue.poll();
            res.add(poll);
            List<Integer> list = lists[poll];
            if(list!=null&&list.size()>0){
                for (int temp : list) {
                    entry[temp]--;
                    if (entry[temp] == 0) {
                        queue.add(temp);
                    }
                }
            }
        }
        if(res.size()<numCourses){
            return new int[]{};
        }
        int[] resInt=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            resInt[i]=res.get(i);
        }
        return resInt;
    }


    @Test
    public void test1(){
//        int[] order = findOrder(6, new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4},{1,3}});
//        int[] order = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        int[] order = findOrder(4, new int[][]{{1,2},{2,1}});
        for(int o:order){
            System.out.println(o);
        }
    }
}
