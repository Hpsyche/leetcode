package com.hpsyche.leetcode.mianshi;

import com.hpsyche.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hpsyche
 * Create on 2020/6/26
 */
public class Question02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set=new HashSet<>();
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while (prev.next!=null){
            if(!set.contains(prev.next.val)){
                set.add(prev.next.val);
                prev=prev.next;
            }else{
                prev.next=prev.next.next;
            }
        }
        return dummy.next;
    }
}
