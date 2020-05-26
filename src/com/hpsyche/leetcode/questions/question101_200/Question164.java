package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/26
 */
public class Question164 {
    /**
     * @author JZNS7JSMJ6
     *
     * 好多人不明白为什么只考虑桶间间隔，而不考虑桶内间隔。
     * 其实在定义桶大小和个数的时候，就保证了分配之后桶内相邻间隔必然小于有效的桶间数的最大间隔。
     * 桶的大小：（最大数-最小数）/（数组大小-1）。（如果桶大小为0，则设为1）
     * 桶的个数：（最大数-最小数）/ 桶的大小 +1。
     *
     * 这是可以证明的，我们用反证法来解释。
     * 假设存在一个这样一个桶，桶内数的间隔大于有序数组内相邻数的最大间隔，那就说明有序数组内相邻数的最大间隔必然小于桶的大小。
     * 也就是说有序数组内所有相邻数的间隔都小于桶的大小，换句话说，数组的大小必然大于桶的个数！
     * 这是不可能的。
     * 因为桶的个数定义为（最大数-最小数）/ 桶的大小 +1，这个定义保证即使所有相邻数间隔为1（此时桶大小为1），
     * 桶的个数也才等于数组个数，正好一个桶一个数。而一旦存在相邻数间隔大于1，假设现在桶的大小还是1，
     * 那么此时桶的个数就必然大于数组个数。这与之前的假设得出的结论相悖。
     *
     */
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int len=nums.length;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(max==min){
            return 0;
        }
        int[] mins=new int[len+1];
        int[] maxs=new int[len+1];
        boolean[] hasNum=new boolean[len+1];
        for (int num : nums) {
            int bid = bucket(num, len, min, max);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num) : num;
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], num) : num;
            hasNum[bid] = true;
        }
        int prev=maxs[0];
        int maxGap=Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            if(hasNum[i]){
                maxGap=Math.max(maxGap,mins[i]-prev);
                prev=maxs[i];
            }
        }
        return maxGap;
    }

    private int bucket(long num, long len, long min, long max) {
        return (int)((num-min)*len/(max-min));
    }
}
