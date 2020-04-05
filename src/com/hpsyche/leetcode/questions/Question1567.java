package com.hpsyche.leetcode.questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/3/27
 */
public class Question1567 {
    /**
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if(target==1){
            return new int[][]{};
        }
        int left=1;
        int right=2;
        int end=(target+1)/2;
        List<int[]> res=new ArrayList<>();
        while(left<end){
            int sum=getSum(left,right);
            if(sum==target){
                int[] temp=new int[right-left+1];
                for(int i=left;i<=right;i++){
                    temp[i-left]=i;
                }
                res.add(temp);
                left++;
            }else if(sum<target){
                right++;
            }else{
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private int getSum(int left, int right) {
        return (right-left+1)*(left+right)/2;
    }

    @Test
    public void test(){
        int[][] continuousSequence = findContinuousSequence(9);
        for(int[] temp:continuousSequence){
            for(int i:temp){
                System.out.printf(i+" ");
            }
            System.out.println();
        }
    }
}
