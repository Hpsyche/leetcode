package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/6/25
 */
public class Question315 {
    private int[] index;
    private int[] helper;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new ArrayList<>(nums.length);
        if(nums.length == 0){
            return list;
        }
        index=new int[nums.length];
        helper=new int[nums.length];
        count=new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i]=i;
        }
        sortProcess(nums,0,nums.length-1);
        for (int i = 0; i < count.length; i++) {
            list.add(i,count[i]);
        }
        return list;
    }

    private void sortProcess(int[] nums, int L, int R) {
        if(L==R){
            return;
        }
        int mid=(L+R)>>1;
        sortProcess(nums,L,mid);
        sortProcess(nums,mid+1,R);
        merge(nums,L,R);

    }

    private void merge(int[] nums, int l, int r) {
        int mid=(l+r)>>1;
        int i=l;
        int j=mid+1;
        int curr=l;
        while (i<=mid&&j<=r){
            if(nums[index[i]]<=nums[index[j]]){
                //index:这个映射的键是下标，值是在初始化的时候，当前元素的数值的索引
                helper[curr++]=index[j++];
            }else{
                count[index[i]]+=r-j+1;
                helper[curr++]=index[i++];
            }
        }
        while (i<=mid){
            helper[curr++]=index[i++];
        }
        while (j<=r){
            helper[curr++]=index[j++];
        }
        for (int k = l; k <= r; k++) {
            index[k]=helper[k];
        }
    }

    @Test
    public void test1(){
        int[] nums=new int[]{5,2,6,1};
        List<Integer> list = countSmaller(nums);
        for(int i:list){
            System.out.println(i);
        }
    }
}
