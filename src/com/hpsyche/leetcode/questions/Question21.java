package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/14
 */
public class Question21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode resBefore=head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if (l1!=null){
            head.next=l1;
        }
        if (l2!=null){
            head.next=l2;
        }

        return resBefore.next;
    }

    @Test
    public void test1(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        l1.next=l2;
        l2.next=l3;

        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;

        ListNode listNode = mergeTwoLists(l1, l4);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }

}
