package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/3/25
 */
public class Question143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Stack<ListNode> stack=new Stack<>();
        while (slow.next!=null){
            stack.add(slow.next);
            slow=slow.next;
        }
        ListNode start=head;
        while (!stack.isEmpty()){
            ListNode temp=stack.pop();
            temp.next=start.next;
            start.next=temp;
            start=temp.next;
        }
        start.next=null;
    }

    @Test
    public void test1(){
        ListNode head=new ListNode(1);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(3);
        ListNode head3=new ListNode(4);
        ListNode head4=new ListNode(5);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
