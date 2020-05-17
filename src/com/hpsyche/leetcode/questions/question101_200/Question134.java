package com.hpsyche.leetcode.questions.question101_200;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/17
 */
public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr=0;
        int pos=0;
        for(int i=0;i<gas.length;i++){
            int count=0;
            while (count<gas.length){
                count++;
                if(curr+gas[pos+i]<cost[pos+i]){
                    break;
                }
                if(count==gas.length){
                    return i;
                }
                curr=curr+gas[pos+i]-cost[pos+i];
                pos++;
                if(pos+i==gas.length){
                    pos=-i;
                }
            }
            curr=0;
            pos=0;
        }
        return -1;
    }

    @Test
    public void test1(){
//        int[] gas=new int[]{1,2,3,4,5};
//        int[] cost=new int[]{3,4,5,1,2};
        int[] gas=new int[]{3};
        int[] cost=new int[]{2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}
