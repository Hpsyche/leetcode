package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hpsyche
 * Create on 2020/3/20
 */
public class Question40 {
      public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
                  @Override
                  public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                  }
            });
            for(int i:arr){
                  if(priorityQueue.size()<k){
                        priorityQueue.add(i);
                  }else if(!priorityQueue.isEmpty()&&i<priorityQueue.peek()){
                        priorityQueue.poll();
                        priorityQueue.add(i);
                  }
            }
            int[] res=new int[k];
            int curr=0;
            while(!priorityQueue.isEmpty()){
                  res[curr++]=priorityQueue.poll();
            }
            return res;
      }

      @Test
      public void test1(){
            getLeastNumbers(new int[]{3,2,1,5,7,8,0},2);
      }
}
