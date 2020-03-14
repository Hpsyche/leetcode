package com.hpsyche.leetcode;

import com.hpsyche.leetcode.utils.ListNode;

/**
 * @author hpsyche
 * Create on 2019/12/14
 */
public class Question234 {
    public boolean isPalindrome(ListNode head) {
        //1.快慢指针到达，慢指针到达中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        //2.将后半部分转置
        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        //3.同时遍历
        while(head!=null&&prev!=null){
            if(head.val!=prev.val){
                return false;
            }
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}
