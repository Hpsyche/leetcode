package com.hpsyche.leetcode.questions.question301_400;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2020/7/1
 */
public class Question328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ji = head;
        ListNode ou = head;
        ListNode p = ou;
        while (ji.next != null && ou.next != null) {
            ji.next = ou.next;
            ji = ji.next;
            ou.next = ji.next;
            ou = ou.next;
        }
        ji.next = p;
        return ji;
    }
}
