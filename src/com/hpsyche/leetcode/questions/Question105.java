package com.hpsyche.leetcode.questions;

import com.hpsyche.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
* @author hpsyche
* Create on 2020/3/28
*/
public class Question105 {
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    for (int i = 0; i < inorder.length; i++) {
        if (preorder[0] == inorder[i]) {
            int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
            int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
            int[] inoLeft = Arrays.copyOfRange(inorder, 0, i);
            int[] inoRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
            root.left = buildTree(preLeft, inoLeft);
            root.right = buildTree(preRight, inoRight);
            break;
        }
    }
    return root;

}


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
        return null;
    }
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
}

    private TreeNode helper(int[] preorder, int preB, int preE, int[] inorder, int inoB, int inoE) {
        if (preB > preE || inoB > inoE) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preB]);
        int i=0;
        for(;i<=inoE;i++){
            if(inorder[inoB+i]==preorder[preB]){
                break;
            }
        }
        root.left = helper(preorder, preB + 1, preB + i, inorder, inoB, inoB + i - 1);
        root.right = helper(preorder, preB + i + 1, preE, inorder, inoB + i + 1, inoE);
        return root;
    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        lengthOfLongestSubstring("abcssda");
    }
}
