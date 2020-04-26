package com.hpsyche.leetcode.questions.question1_100;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/4/26
 */
public class Question83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while (curr!=null&&curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
}
