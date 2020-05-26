package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/5/26
 */
public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA;
        int aCount=0;
        while (currA!=null){
            aCount++;
            currA=currA.next;
        }
        ListNode currB=headB;
        int bCount=0;
        while (currB!=null){
            bCount++;
            currB=currB.next;
        }
        currA=headA;
        currB=headB;
        if(aCount>bCount){
            for(int i=0;i<(aCount-bCount);i++){
                currA=currA.next;
            }
        }else if(aCount<bCount){
            for(int i=0;i<(bCount-aCount);i++){
                currB=currB.next;
            }
        }
        while (currA!=null&&currB!=null){
            if(currA==currB){
                return currA;
            }
            currA=currA.next;
            currB=currB.next;
        }
        return null;
    }


}
