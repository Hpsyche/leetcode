package com.hpsyche.leetcode.mianshi;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/6/26
 */
public class Question02_01_2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while (prev.next!=null){
            ListNode curr=prev.next;
            while (curr.next!=null){
                if(prev.next.val==curr.next.val){
                    curr.next=curr.next.next;
                }else{
                    curr=curr.next;
                }
            }
            prev=prev.next;
        }
        return dummy.next;
    }
}
