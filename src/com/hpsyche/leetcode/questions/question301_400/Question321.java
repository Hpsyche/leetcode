package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/6/28
 */
public class Question321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max=new int[k];
        for(int i=0;i<=k;i++){
            if(i<=nums1.length&&(k-i)<=nums2.length) {
                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i));
                if (compareBigger(temp, max)) {
                    max = temp;
                }
            }
        }
        return max;
    }

    private boolean compareBigger(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length){
            return true;
        }else if(arr1.length<arr2.length){
            return false;
        }else{
            int curr=0;
            while (curr<arr1.length){
                if(arr1[curr]!=arr2[curr]){
                    return arr1[curr]>arr2[curr];
                }
                curr++;
            }
            return false;
        }
    }


    private int[] merge(int[] arr1, int[] arr2) {
        int len1=arr1.length;
        int len2=arr2.length;
        int[] res=new int[len1+len2];
        int p1=0;
        int p2=0;
        //[2,5,6,4,4,0]
        //[7,3,8,0,6,5,7,6,2]
        for(int i=0;i<(len1+len2);i++){
            if(compare(Arrays.copyOfRange(arr1,p1,len1),Arrays.copyOfRange(arr2,p2,len2))){
                res[i]=arr1[p1++];
            }else{
                res[i]=arr2[p2++];
            }
        }
        return res;
    }

    //比较数组的逻辑大小，如果数组长短不一样并且前n个数字完全一样，则认为长度大的那个数组大
    //返回值：若nums1>nums2，返回true
    private boolean compare(int[] arr1, int[] arr2) {
        int n=Math.min(arr1.length,arr2.length);
        for (int i = 0; i < n; i++) {
            if(arr1[i]>arr2[i]){
                return true;
            }else if(arr1[i]<arr2[i]){
                return false;
            }
        }
        return arr1.length>arr2.length;
    }

    private int[] getMax(int[] arr, int i) {
//        System.out.println(Arrays.toString(arr));
//        System.out.println(i);
        Stack<Integer> stack=new Stack<>();
        int remove=arr.length-i;
        for(int num:arr){
            while (remove>0&&!stack.isEmpty()&&num>stack.peek()){
                stack.pop();
                remove-=1;
            }
            stack.push(num);
        }
        int[] res=new int[i];
        for (int j = 0; j < i; j++) {
            res[j]=stack.get(j);
        }
        return res;
    }

    @Test
    public void test1(){
//[2,5,6,4,4,0]
//[7,3,8,0,6,5,7,6,2]
//        15
        int[] num1=new int[]{2,5,6,4,4,0};
        int[] num2=new int[]{7,3,8,0,6,5,7,6,2};
        int[] ints = maxNumber(num1, num2, 15);
        for (int i:ints) {
            System.out.println(i);
        }
    }
}
