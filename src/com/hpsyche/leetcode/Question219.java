package com.hpsyche.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2019/12/11
 */
public class Question219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if((i-map.get(nums[i]))<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,0,1};
        System.out.println(containsNearbyDuplicate(nums,3));
    }
}
