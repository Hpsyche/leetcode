package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/3/31
 */
public class Question82 {
    /**
*         //如果是这种情况
*         //      1 --> 1 --> 1 --> 2 --> 3
*         //     head  next
*         //1.则需要移动next直到出现与当前head.value不相等的情况（含null）
*         //2.并且此时的head已经不能要了，因为已经head是重复的节点
*         //--------------else-------------
*         //      1 --> 2 --> 3
*         //     head  next
*         //3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        if(head.val==next.val){
            while (next!=null&&head.val==next.val){
                next=next.next;
            }
            head=deleteDuplicates(next);
        }else{
            head.next=deleteDuplicates(next);
        }
        return head;
    }


    /**
     * 正常思路
     * 注意：
     * 为了防止删除头结点的极端情况发生，先创建空结点dummy，使dummy指向传入的head结点。
     * 然后创建cur的指针，指向链表的头部（即dummy）。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                ListNode temp=cur.next;
                while (temp.next!=null&&temp.val==temp.next.val){
                    temp=temp.next;
                }
                cur.next=temp.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }

}
