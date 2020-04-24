package com.hpsyche.leetcode.questions.question1_100;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/19
 * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
 * 将负数，零，大于 n 的数替换为 1 。
 * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
 * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
 * 再次遍历数组。返回第一个正数元素的下标。
 * 如果 nums[0] > 0，则返回 n 。
 * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
 *
 */
public class Question41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        for (int num : nums){
            if (num == 1) {
                flag = true;
                break;
            }
        }
        if(!flag){
            return 1;
        }
        for(int i=0;i<len;i++){
            if(nums[i]<=0||nums[i]>len){
                nums[i]=1;
            }
        }
        for(int i=0;i<len;i++){
            int indexNum=Math.abs(nums[i])-1;
            if(nums[indexNum]<0){
                continue;
            }
            nums[indexNum]=-nums[indexNum];
        }
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return len+1;
    }

    @Test
    public void test1(){
        int i = firstMissingPositive(new int[]{-1,-2});
        System.out.println(i);
    }
}
