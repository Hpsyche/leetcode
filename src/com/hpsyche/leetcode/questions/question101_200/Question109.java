package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;
import com.hpsyche.leetcode.utils.TreeNode;

/**
 * @author hpsyche
 * Create on 2020/5/8
 */
public class Question109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mid=getMid(head);
        TreeNode root=new TreeNode(mid.val);
        if(head==mid){
            return root;
        }
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }

    private ListNode getMid(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev=null;

        while (fastPtr != null && fastPtr.next != null) {
            prev=slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(prev!=null) {
            prev.next = null;
        }
        return slowPtr;
    }
}
