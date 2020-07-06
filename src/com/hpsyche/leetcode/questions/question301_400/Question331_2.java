package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/7/6
 */
public class Question331_2 {
    public boolean isValidSerialization(String preorder) {
        int len=preorder.length();
        int num=0;
        for (int i = len-1; i >=0 ; i--) {
            if(preorder.charAt(i)==','){
                continue;
            }
            if(preorder.charAt(i)=='#'){
                num++;
            }else{
                while (i>=0&&preorder.charAt(i)!=','){
                    i--;
                }
                if(num>=2){
                    num--;
                }else{
                    return false;
                }
            }
        }
        return num==1;
    }
}