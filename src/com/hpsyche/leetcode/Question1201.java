package com.hpsyche.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/3/23
 */
public class Question1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low=Math.min(Math.min(a,b),c);
        int high=low*n;
        int res=binary_search(low,high,a,b,c,n);
        int left_a=res%a;
        int left_b=res%b;
        int left_c=res%c;
        return res-Math.min(left_a,Math.min(left_b,left_c));
    }

    private int binary_search(int low, int high, int a, int b, int c,int n) {
        if(low>=high){
            return low;
        }
        int mid=(low+high)>>1;
        int mcm_a_b=mcm(a,b);
        int mcm_a_c=mcm(a,c);
        int mcm_b_c=mcm(b,c);
        int mcm_a_b_c=mcm(mcm_a_b,c);
        int count_n= mid/a + mid/b + mid/c - mid/mcm_a_b - mid/mcm_b_c - mid/mcm_a_c +  mid/mcm_a_b_c;
        if(count_n==n){
            return mid;
        }
        if(count_n<n){
            return binary_search(mid+1,high,a,b,c,n);
        }
        return binary_search(low,mid-1,a,b,c,n);
    }

    private int mcm(int a, int b) {
        int multi=a*b;
        while(b>0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return multi/a;
    }

    @Test
    public void test1(){
        System.out.println(nthUglyNumber(1000000000,2,217983653,336916467));
    }
}
