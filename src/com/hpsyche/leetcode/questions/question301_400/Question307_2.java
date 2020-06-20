package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/6/20
 * 线段树
 */
public class Question307_2 {
    private int[] tree;
    private int size;

    public Question307_2(int[] nums) {
        int len=nums.length;
        this.tree=new int[len*2];
        this.size=len;
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for(int i=size,j=0;j<size;i++,j++){
            tree[i]=nums[j];
        }
        for(int i=size-1;i>0;i--){
            tree[i]=tree[i*2]+tree[i*2+1];
        }
        System.out.println(6);
    }

    public void update(int i, int val) {
        i+=size;
        tree[i]=val;
        while (i>0){
            int left=i;
            int right=i;
            if(i%2==0){
                right=i+1;
            }else{
                left=i-1;
            }
            tree[i/2]=tree[left]+tree[right];
            i/=2;
        }
    }

    public int sumRange(int i, int j) {
        i+=size;
        j+=size;
        int sum=0;
        while (i<=j){
            if(i%2!=0){
                sum+=tree[i];
                i+=1;
            }
            if(j%2!=1){
                sum+=tree[j];
                j-=1;
            }
            i/=2;
            j/=2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5};
        Question307_2 question307=new Question307_2(nums);
        System.out.println(question307.sumRange(0,2));;
        question307.update(1,2);
        System.out.println(question307.sumRange(0,2));;

    }
}
