package com.hpsyche.leetcode.shopee;

import java.util.Scanner;

/**
 * @author hpsyche
 * Create on 2020/2/15
 * 1.10.1,1.2.3
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String scanIn = scanner.nextLine();
//        1.10.1, 1.2.3
        String version1=scanIn.split(", ")[0];
        String version2=scanIn.split(", ")[1];
        int[] arr1 = splitVersion(version1);
        int[] arr2 = splitVersion(version2);
        int maxLength= Math.max(arr1.length, arr2.length);
        for(int i=0;i<maxLength;i++){
            if(arr1.length<i){
                System.out.println(-1);
                return;
            }
            if(arr2.length<i){
                System.out.println(1);
                return;
            }
            if(arr1[i]>arr2[i]){
                System.out.println(1);
                return;
            }
            if(arr1[i]<arr2[i]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(0);

    }

    public static int[] splitVersion(String str){
        String[] split = str.split("\\.");
        int[] res=new int[split.length];
        for(int i=0;i<res.length;i++){
            res[i]=Integer.parseInt(split[i]);
        }
        return res;
    }
}
