//package com.hpsyche.leetcode.questions.question301_400;
//
///**
// * @author hpsyche
// * Create on 2020/6/28
// */
//public class Question321 {
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int p1=0;
//        int p2=0;
//        int len1=nums1.length;
//        int len2=nums2.length;
//        int curr1=0;
//        int curr2=0;
//        for (int i = 0; i < k; i++) {
//            p1=curr1;
//            p2=curr2;
//            while (curr1<len1&&curr2<len2){
//                if((len1-curr1+len2-curr2)<(k-i)){
//                    break;
//                }
//                if(nums1[curr1]>nums2[curr2]){
//                    curr1++;
//                }else{
//                    curr2++;
//                }
//            }
//            if(nums1[curr1]>nums2[curr2]){
//
//            }
//        }
//
//    }
//}
