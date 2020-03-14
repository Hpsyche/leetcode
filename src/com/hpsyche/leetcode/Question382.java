package com.hpsyche.leetcode;

import com.hpsyche.leetcode.utils.ListNode;

import java.util.Random;

/**
 * @author hpsyche
 * Create on 2020/3/12
 */
public class Question382 {
    private ListNode head;
    public Question382(ListNode head) {
        this.head=head;
    }

    /** Returns a random node's value. */
    /**
     * random.nextInt(i)==0这行代码决定了最后输出的res，即所有满足该条件且i最大的no.val会被输出。
     * 那么我们不妨以i的值降序来看这里的while循环：
     *
     * 设链表长n，则i==n时执行res=no.val的概率为1/n，即最终选择第n的点的概率是1/n；
     * 而最终选择第n-1个点的情况，就要求第n个点不被选，且i==n-1时执行了res=no.val，即(1-1/n)*(1/(n-1))=1/n...
     * 以此类推，所有n个点被选的概率都是1/n。
     * @return
     */
    public int getRandom() {
        int res=head.val;
        ListNode next=head.next;
        int i=2;
        Random random=new Random();
        while (next!=null){
            if(random.nextInt(i)==0){
                res=next.val;
            }
            i++;
            next=next.next;
        }
        return res;
    }
}
