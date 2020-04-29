package com.hpsyche.leetcode.questions.question1001_1100;

/**
 * @author hpsyche
 * Create on 2020/4/29
 */
public class Question1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0;
        int r=mountainArr.length()-1;
        while (l<r){
            int mid=(l+r)>>1;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        int peek=l;
        int index=binary_search(mountainArr,target,0,peek,1);
        if(index!=-1){
            return index;
        }
        return binary_search(mountainArr,target,peek+1,mountainArr.length()-1,-1);
    }

    private int binary_search(MountainArray mountainArr, int target, int left, int right,int reverse) {
        target*=reverse;
        while (left<=right){
            int mid=(left+right)>>1;
            int res=reverse*mountainArr.get(mid);
            if(res==target){
                return mid;
            }else if(res>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    interface MountainArray {
        int get(int index);
        int length();
    }
}
