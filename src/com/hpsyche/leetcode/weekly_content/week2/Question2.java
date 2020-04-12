package com.hpsyche.leetcode.weekly_content.week2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/4/12
 */
public class Question2 {
    public int[] processQueries(int[] queries, int m) {
        int[] nums=new int[m];
        for(int i=0;i<m;i++){
            nums[i]=i;
        }
        List<Integer> list=new ArrayList<>();
        for(int query:queries){
            int temp=nums[query-1];
            list.add(temp);
            for(int i=0;i<m;i++){
                if(nums[i]<temp){
                    nums[i]++;
                }else if(nums[i]==temp){
                    nums[i]=0;
                }
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }

    @Test
    public void test1(){
        int[] ints = processQueries(new int[]{8,7,4,2,8,1,7,7}, 8);
        for(int i:ints){
            System.out.println(i);
        }

    }
}
