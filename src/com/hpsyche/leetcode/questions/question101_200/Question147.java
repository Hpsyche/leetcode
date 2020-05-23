package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/5/23
 */
public class Question147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(0);
        ListNode prev;
        dummy.next=head;
        while (head!=null&&head.next!=null){
            if(head.val<=head.next.val){
                head=head.next;
                continue;
            }
            prev=dummy;
            while (prev.next.val<head.next.val) {
                prev=prev.next;
            }
            ListNode curr=head.next;
            head.next=curr.next;
            curr.next=prev.next;
            prev.next=curr;
        }
        return dummy.next;
    }
}
