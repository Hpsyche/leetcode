package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/4/28
 */
public class Question86 {
    public ListNode partition(ListNode head, int x) {
        ListNode prev1=new ListNode(-1);
        ListNode prev2=new ListNode(-1);
        ListNode node1=prev1;
        ListNode node2=prev2;
        while (head!=null){
            if(head.val<x){
                node1.next=head;
                head=head.next;
                node1=node1.next;
                node1.next=null;
            }else{
                node2.next=head;
                head=head.next;
                node2=node2.next;
                node2.next=null;
            }
        }
        node1.next=prev2.next;
        return prev1.next;
    }
}
