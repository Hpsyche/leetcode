package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/4/29
 */
public class Question92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        for(int i=1;i<m;i++){
            curr=curr.next;
        }
        ListNode newHead=curr.next;
        ListNode next=null;
        ListNode prev=null;
        for(int i=m;i<=n;i++){
            next=newHead.next;
            newHead.next=prev;
            prev=newHead;
            newHead=next;
        }
        curr.next.next=next;
        curr.next=prev;
        return dummy.next;
    }
}
