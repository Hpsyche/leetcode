package com.hpsyche.leetcode.questions.question1301_1400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hpsyche
 * Create on 2020/3/18
 */
public class Question1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] temp=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp, (o1, o2) -> {
            int i1 = Integer.bitCount(o1);
            int i2 = Integer.bitCount(o2);
            return i1==i2?o1-o2:i1-i2;
        });
        for(int i=0;i<arr.length;i++){
            arr[i]=temp[i];
        }
        return arr;
    }

    public void insertSort(int[] arr){
        if(arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int curr=arr[i+1];
            int index=i;
            while (index>=0&&curr<arr[index]){
                arr[curr+1]=arr[curr];
                index--;
            }
            arr[index+1]=curr;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    @Test
    public void test1(){
        int[] arr=new int[]{0,1,2,3,4,5,6,7,8};
        int[] ints = sortByBits(arr);
        for(int i:ints){
            System.out.println(i);
        }
    }
}
