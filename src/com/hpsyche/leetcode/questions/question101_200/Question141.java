package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/5/15
 */
public class Question141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
