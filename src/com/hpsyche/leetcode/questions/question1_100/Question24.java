package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/4/14
 */
public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode resBefore=new ListNode(-1);
        resBefore.next=head;
        ListNode prev=resBefore;
        while (head!=null&&head.next!=null){
            ListNode first=head;
            ListNode second=head.next;
            prev.next=second;
            first.next=second.next;
            second.next=first;
            prev=first;
            head=first.next;
        }
        return resBefore.next;
    }
}
