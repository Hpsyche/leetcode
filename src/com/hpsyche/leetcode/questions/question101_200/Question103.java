package com.hpsyche.leetcode.questions.question101_200;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hpsyche
 * Create on 2020/5/6
 */
public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean flag=true;
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> temp=new LinkedList<>();
            while (count>0){
                TreeNode poll=queue.poll();
                if(flag){
                    temp.add(poll.val);
                }else{
                    temp.add(0,poll.val);
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                count--;
            }
            flag=!flag;
            res.add(temp);
        }
        return res;
    }
}
