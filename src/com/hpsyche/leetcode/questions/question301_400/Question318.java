package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/6/28
 */
public class Question318 {
    public int maxProduct(String[] words) {
        int len=words.length;
        //哈希存储，字母位置
        int[] hash=new int[len];
        int max=0;
        for (int i = 0; i < len; i++) {
            for(char c:words[i].toCharArray()){
                hash[i]|=(1<<(c-'a'));
            }
        }
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if((hash[i]&hash[j])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
