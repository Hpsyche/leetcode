package com.hpsyche.leetcode;

import java.util.Arrays;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question912 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public int[] selectSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int min=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
        return nums;
    }

    public int[] quickSort(int[] nums,int begin,int end){
        int l=begin;
        int r=end;
        if (l<r){
            int temp=nums[l];
            while (l<r){
                while (l<r&&nums[r]>=temp){
                    r--;
                }
                if(l<r){
                    nums[l]=nums[r];
                }
                while (l<r&&nums[l]<temp){
                    l++;
                }
                if(l<r){
                    nums[r]=nums[l];
                }
            }
            nums[l]=temp;
            quickSort(nums,begin,l);
            quickSort(nums,l+1,end);
        }
        return nums;
    }

    public int[] insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0&&nums[j]>nums[j+1];j--){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
        }
        return nums;
    }
}
