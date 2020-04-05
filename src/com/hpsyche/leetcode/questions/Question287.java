package com.hpsyche.leetcode.questions;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question287 {
    /**
     * 解答1：通过二分查找
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left=1;
        int right=nums.length;
        int mid;
        while(left<right){
            mid=left+((right-left)>>1);
            int count=0;
            for(int num:nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count<=mid){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }

    /**
     * 解答二：通过快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int fast=0;
        int slow=0;
        while (fast!=slow||fast==0){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int temp=0;
        //快指针每次走2步，慢指针每次走1步。
        //设相遇时快指针走t2步，慢指针走t1步，环长为c。 则相遇时, 快指针比慢指针多走一个环的长度，即 t2 = t1 + c。
        //又t2 = 2t1 （快指针走的步数是慢指针的两倍） 则 2t1 = t1 + c, t1=c，即慢指针走了c步。
        //设环起点在第k步，显然慢指针再走k步就会到达环的终点，也是环的起点。如果设置一个i指针从起点开始走，则慢指针和i指针会在环起点相碰。
        while (slow!=temp){
            temp=nums[temp];
            slow=nums[slow];
        }
        return slow;
    }


    @Test
    public void test1(){
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));;
    }
}
