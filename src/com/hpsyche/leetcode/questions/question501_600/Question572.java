package com.hpsyche.leetcode.questions.question501_600;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/5/7
 */
public class Question572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        return isSameTree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val==t.val){
            return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
        }
        return false;
    }

    @Test
    public void test1(){
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(1);
        TreeNode t5=new TreeNode(2);
//        TreeNode t6=new TreeNode(0);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
//        t5.left=t6;

        TreeNode k1=new TreeNode(4);
        TreeNode k2=new TreeNode(1);
        TreeNode k3=new TreeNode(2);
        k1.left=k2;
        k1.right=k3;
//        TreeNode t1=new TreeNode(1);
//        TreeNode t2=new TreeNode(1);
//        t1.left=t2;
//
//        TreeNode k1=new TreeNode(1);

        System.out.println(isSubtree(t1,k1));
    }
}
