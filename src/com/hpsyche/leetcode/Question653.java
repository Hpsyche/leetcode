package com.hpsyche.leetcode;

import com.hpsyche.leetcode.utils.ListNode;
import com.hpsyche.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/4/1
 */
public class Question653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp!=null) {
                if (set.contains(k - temp.val)) {
                    return true;
                }
                set.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return false;
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if(root==null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return find(root.left,k-root.val,set)||find(root.right,k-root.val,set);
    }

    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int l=0;
        int r=list.size()-1;
        while (l<r){
            int sum=list.get(l)+list.get(r);
            if(sum>k){
                r--;
            }else if(sum<k){
                l++;
            }else {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
