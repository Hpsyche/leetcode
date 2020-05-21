package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/21
 */
public class Question142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        //是否环
        boolean flag=false;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(!flag){
            return null;
        }
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    @Test
    public void test1(){
        ListNode listNode=new ListNode(3);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(0);
        ListNode listNode4=new ListNode(-4);
        listNode.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode2;

        ListNode l=new ListNode(1);

        ListNode listNode1 = detectCycle(l);
        System.out.println(listNode1);
    }
}
