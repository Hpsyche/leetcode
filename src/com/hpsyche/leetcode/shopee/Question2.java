package com.hpsyche.leetcode.shopee;

import java.util.Scanner;

/**
 * @author hpsyche
 * Create on 2020/2/15
 */
public class Question2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        int[] ints = splitVersion(line);
        int count=0;
        int lastNum=-1;
        int currNumCount=0;
        for(int i=0;i<ints.length;i++){
            if(lastNum!=ints[i]){
                lastNum=ints[i];
                currNumCount=0;
            }
            if(currNumCount<ints[i]&&lastNum==ints[i]){
                count++;
                currNumCount++;
            }
        }
        System.out.println(count);
    }

    public static int[] splitVersion(String str){
        String[] split = str.split(" ");
        int[] res=new int[split.length];
        for(int i=0;i<res.length;i++){
            res[i]=Integer.parseInt(split[i]);
        }
        return res;
    }
}
