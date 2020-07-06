package com.hpsyche.leetcode.questions.question301_400;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/7/6
 */
public class Question331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] nums = preorder.split(",");
        for (String num : nums) {
            stack.push(num);
            if ("#".equals(num)) {
                while (stack.size()>2&&stack.get(stack.size() - 2).equals("#") && stack.peek().equals("#")) {
                    stack.pop();
                    stack.pop();
                    String flag = stack.pop();
                    if(flag.equals("#")){
                        return false;
                    }
                    stack.push("#");
                }
            }
        }
        return stack.size()==1&&stack.pop().equals("#");
    }

    @Test
    public void test() {
        System.out.println(isValidSerialization("1,#,#,#,#"));
    }
}
