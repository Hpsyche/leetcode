package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/3/29
 */
public class Question652 {
    Map<String,Integer> trees;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        trees=new HashMap<>();
        res=new ArrayList<>();
        helper(root);
        return res;
    }

    private String helper(TreeNode root) {
        if(root==null){
            return "#";
        }
        String serial=root.val+","+helper(root.left)+","+helper(root.right);
        trees.put(serial,trees.getOrDefault(serial,0)+1);
        if(trees.get(serial)==2){
            res.add(root);
        }
        return serial;
    }

}
