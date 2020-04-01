package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] helper=new Integer[arr1.length];
        for(int i=0;i<arr1.length;i++){
            helper[i]=arr1[i];
        }
        Arrays.sort(helper, (o1, o2) -> {
            int o1IndexInArr2=-1;
            int o2IndexInArr2=-1;
            for(int i=0;i<arr2.length;i++){
                if(o1==arr2[i]){
                    o1IndexInArr2=i;
                }
                if(o2==arr2[i]){
                    o2IndexInArr2=i;
                }
            }
            if(o1IndexInArr2==-1&&o2IndexInArr2==-1){
                return o1.compareTo(o2);
            }else if(o1IndexInArr2==-1){
                return 1;
            }else if(o2IndexInArr2==-1){
                return -1;
            }
            return o1IndexInArr2-o2IndexInArr2;
        });
        for(int i=0;i<arr1.length;i++){
            arr1[i]=helper[i];
        }
        return arr1;
    }

    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] temp=new int[1001];
        for(int i:arr1){
            temp[i]++;
        }
        int index=0;
        for(int j:arr2){
            while (temp[j]>0){
                arr1[index]=j;
                temp[j]--;
                index++;
            }
        }
        for(int i=0;i<temp.length;i++){
            while (temp[i]>0){
                arr1[index++]=i;
                temp[i]--;
            }
        }
        return arr1;
    }

        @Test
    public void test1(){
        int[] ints = relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for(int i:ints){
            System.out.print(i+" ");
        }
    }
}
